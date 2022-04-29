package com.example.controller;

import com.example.datagenerator.DataGenerator;
import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    public String employeeRegister(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("states",DataGenerator.getStateList());
        return "employee/register";
    }

    @PostMapping("/list")
    public String employeeList(@ModelAttribute("employee")Employee employee, Model model){
        model.addAttribute("employeeList", Arrays.asList(employee));
        LocalDate dob = LocalDate.parse(employee.getBirthday());
        System.out.println("DOB: " + dob);
        int age = LocalDate.now().getYear() - dob.getYear();
        model.addAttribute("age", age);
        //employee.setAge(age);
        return "employee/employee-list";
    }
}
