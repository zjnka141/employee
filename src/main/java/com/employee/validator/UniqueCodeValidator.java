package com.employee.validator;

import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode,String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(employeeRepository==null){
            return true;
        }
        return employeeRepository.countByEmployeeCode(value)<=0;
    }
}
