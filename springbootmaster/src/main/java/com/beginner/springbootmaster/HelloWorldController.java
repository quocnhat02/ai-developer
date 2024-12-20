package com.beginner.springbootmaster;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/page")
    public String homePages(@RequestParam(name = "userId", defaultValue = "User") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "index";
    }
}
