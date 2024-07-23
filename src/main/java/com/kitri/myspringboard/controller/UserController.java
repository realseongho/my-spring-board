package com.kitri.myspringboard.controller;

import com.kitri.myspringboard.domain.User;
import com.kitri.myspringboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping("/signup")
    public String signupForm(Model model) {
        return "user/signup";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
        userService.signup(user);
        return "redirect:/login";
    }
}