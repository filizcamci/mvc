package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping
    public String home(){
        return "home";
    }

    @GetMapping("/filiz")
    public String filiz(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableExample(@PathVariable("name") String name){
        System.out.println("name: " + name);
        return "home";
    }
    @GetMapping("home/address")
    public String requestParamExample(@RequestParam("address") String address){
        System.out.println("address: " + address);
        return "home";
    }
    @GetMapping("/welcome")
    public String welcomePage(Model model){
        String name = "Fatih";
        model.addAttribute("name", name);
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        model.addAttribute("numbers", list);
        LocalDate dob = LocalDate.now().minusYears(42);
        model.addAttribute("dob", dob);
        return "user/welcome";
    }
}
