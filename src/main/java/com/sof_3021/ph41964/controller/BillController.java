package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list",billService.getAll());
        return "admin/bill/Index";
    }


    @GetMapping("/remove")
    public String remove(@RequestParam("id") int id) {
        billService.remove(id);
        return "redirect:/bill";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id,
                         Model model) {
        model.addAttribute("bill", billService.getById(id));
        return "admin/bill/Detail";
    }


    @GetMapping("/search")
    public String search(@RequestParam("search") int search,
                         Model model) {

        model.addAttribute("bill", billService.getById(search));

        return "admin/bill/Detail";
    }

}
