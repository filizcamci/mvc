package com.example.controller;

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
        List<String> states = Arrays.asList("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii"
                ,"Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri"
                ,"Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania"
                ,"Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming");
        model.addAttribute("states",states);
        return "employee/register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("employee")Employee employee){
        LocalDate dob = LocalDate.parse(employee.getBirthday());
        System.out.println("DOB: " + dob);
        int age = LocalDate.now().getYear() - dob.getYear();
        employee.setAge(age);
        return "employee/confirm";
    }
}
