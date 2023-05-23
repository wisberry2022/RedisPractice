package com.example.redis01.controller;

import com.example.redis01.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoginService loginService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @PostMapping("/login")
    public String goLogin(String id, String pwd) {

        loginService.setToken(id, pwd);

        return "redirect:/";
    }

    @GetMapping("/check")
    public String getUser(String id) {
        loginService.getUser(id);
        return "redirect:/";
    }
}
