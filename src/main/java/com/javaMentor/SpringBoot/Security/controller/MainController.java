package com.javaMentor.SpringBoot.Security.controller;

import com.javaMentor.SpringBoot.Security.model.User;
import com.javaMentor.SpringBoot.Security.service.RoleService;
import com.javaMentor.SpringBoot.Security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    private final RoleService roleService;
    private final UserService userService;

    public MainController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getMain(Model model){
        model.addAttribute("user",  userService.findUserByName(userService.getCurrentUsername()));
        model.addAttribute("allRoles", roleService.allRoles());
        return "adminBT";
    }

    @GetMapping("/user")
    public String getUserPage(Model model){
        model.addAttribute("user",  userService.findUserByName(userService.getCurrentUsername()));
        return "userBT";
    }
}
