package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list", productService.getAllActive());
        return "employee/product/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search,
                         Model model) {
        model.addAttribute("list", productService.search(search));
        return "employee/product/Index";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model) {
        model.addAttribute("product", productService.getById(Integer.valueOf(id)));
        return "employee/product/Detail";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") String id,
                         Model model) {
        Product product = productService.getById(Integer.valueOf(id));
        product.setStatus(false);
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("create")
    public String createView(@RequestParam("id") String id,
                         Model model) {
        Product product = productService.getById(Integer.valueOf(id));
        product.setStatus(false);
        productService.update(product);
        return "redirect:/product";
    }

}
