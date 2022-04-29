package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/welcome")
    public String welcomeUser(Model model){
        User user1 = new User(1, "Mike", "Smith");
        model.addAttribute("user1", user1);
        model.addAttribute("id",user1.getId());
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        model.addAttribute("numbers", list);
        return "user/welcome";
    }
    @GetMapping("/welcome/{id}")
    public String welcomeUserwId(@RequestParam("id") String id){
        return "user/register";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/list")
    public String getUserList(Model model){
        List<User> users = new ArrayList();
        users.add(new User(2, "Filiz", "Camci"));
        users.add(new User(3, "Ayse", "Turk"));
        users.add(new User(4, "Emine", "Tekin"));
        users.add(new User(5, "Zeynep", "Bodur"));
        model.addAttribute("users",users);
        return "user/user-list";
    }

}
