package com.example.controller;

import com.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        List<String> batchList = Arrays.asList("B7","B8","B9","E1");
        model.addAttribute("batchList", batchList);
        return "student/register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("student") Student student){
        System.out.println(student.toString());

        return "student/confirm";
    }
}
