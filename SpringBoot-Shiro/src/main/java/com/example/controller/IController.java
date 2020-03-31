package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "This first SpringBootShiro");
        return "index";
    }
}
