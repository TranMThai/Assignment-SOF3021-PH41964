package com.sof_3021.ph41964.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @GetMapping("/reject-access")
    public String index(Model model) {
        model.addAttribute("message","Chỉ có ADMIN mới có thể truy cập được chức năng này!!!");
        return "Error";
    }
}
