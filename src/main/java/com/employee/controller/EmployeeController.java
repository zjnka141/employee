package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("")
    public String listAll(Model model){
        List<Employee> employeeList=employeeRepository.findAll();
        model.addAttribute("employeeList",employeeList);
        return "home";
    }
    @GetMapping("/add")
    public String addEmpoyee(Model model){
        model.addAttribute("employee",new Employee());
        return "form";
    }
    @PostMapping("/add")
    public String addEmpoyee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/edit/{code}")
    public String editEmployee(@PathVariable("code") String code, Model model ){
        model.addAttribute("edit",true);
        Employee employee=employeeRepository.findByEmployeeCode(code);
        model.addAttribute("employee",employee);
        return "form";
    }
    @PostMapping("/edit/{code}")
    public String editEmployee(@PathVariable("code") String code, @Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if(employee.getEmployeeCode().equals(code)){
            List allErrors = bindingResult.getAllErrors();
            if(allErrors.size()==1){
                employeeRepository.save(employee);
                return "redirect:/";
            }else{
                return "form";
            }
        }
        else if(bindingResult.hasErrors()){
            return "form";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/delete/{code}")
    public String deleteEmployee(@PathVariable("code") String code){
        employeeRepository.delete(employeeRepository.findByEmployeeCode(code));
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(@RequestParam("searchText") String searchText, Model model){
        List<Employee> employees=employeeRepository.findByNameContainingIgnoreCase(searchText);
        if(employees.isEmpty()){
            employees=employeeRepository.findByEmployeeCodeContainingIgnoreCase(searchText);
        }
        model.addAttribute("employeeList",employees);
        return "home";
    }
}
