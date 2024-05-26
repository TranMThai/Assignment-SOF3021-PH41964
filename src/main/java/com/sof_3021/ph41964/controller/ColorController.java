package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ColorController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String home(Model model) {

        return "admin/bill/home";
    }

}
