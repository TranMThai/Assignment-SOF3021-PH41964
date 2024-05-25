package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sell")
public class SellController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String index(){
        return "employee/sell/Index";
    }

}
