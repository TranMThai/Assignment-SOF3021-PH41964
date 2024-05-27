package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Product;
import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.service.ProductDetailService;
import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product_detail")
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list", productDetailService.getAllActive());
        return "employee/productDetail/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search,
                         Model model) {
        model.addAttribute("list", productDetailService.search(search));
        return "employee/productDetail/Index";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model) {
        model.addAttribute("pd", productDetailService.getById(Integer.valueOf(id)));
        return "employee/productDetail/Detail";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") String id,
                         Model model) {
        ProductDetail productDetail = productDetailService.getById(Integer.valueOf(id));
        productDetail.setStatus(false);
        productDetailService.update(productDetail);
        return "redirect:/product_detail";
    }

    @PostMapping("update")
    public String update(@RequestParam("id") String id,
                         @RequestParam("quantity") String quantity) {
        ProductDetail productDetail = productDetailService.getById(Integer.valueOf(id));
        productDetail.setQuantity(Integer.valueOf(quantity));
        productDetailService.update(productDetail);
        return "redirect:/product_detail";
    }
}
