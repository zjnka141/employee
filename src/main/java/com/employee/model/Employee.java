package com.employee.model;

import com.employee.validator.UniqueCode;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @UniqueCode
    private String employeeCode;
    @NotNull
    private String employeeGroup;
    @NotBlank(message = "* Vui lòng nhập trường này")
    @Size(min=2,max=30,message = "* Chiều dài phải >2 và <30 ký tự")
    private String name;
    @Pattern(regexp = "(^\\d{2}/\\d{1,2}/\\d{4})",message = "* Format is dd/mm/yyyy")
    private String birthday;
    @NotNull(message = "* Vui lòng nhập trường này")
    private String gender;
    @NotBlank(message = "* Vui lòng nhập trường này")
    @Pattern(regexp = "(^\\d{8,12})",message = "* Số điện thoại không hợp lệ")
    private String phone;
    @Pattern(regexp = "(^\\d{6,})",message = "* CMND không hợp lệ")
    private String cmnd;
    @NotBlank(message = "* Vui lòng nhập trường này")
    @Pattern(regexp = "(^\\w+@[a-z]+\\.[a-z]+)",message = "* Email không hợp lệ")
    private String email;
    private String address;

    public Employee() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
