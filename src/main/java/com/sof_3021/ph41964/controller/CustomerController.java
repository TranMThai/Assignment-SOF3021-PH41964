package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ModelAttribute("customer")
    public Customer getCustomer() {
        return new Customer();
    }

    @GetMapping("")
    public String index(@RequestParam(name = "page", defaultValue = "0") Integer page,
                        Model model) {
        model.addAttribute("list", customerService.getByPageActive(page));
        model.addAttribute("url", "/customer?");
        return "employee/customer/Index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "page", defaultValue = "0") Integer page,
                         @RequestParam("search") String search,
                         Model model) {
        model.addAttribute("list", customerService.search(page,search));
        model.addAttribute("url", "/customer?search="+search+"&");
        return "employee/customer/Index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model) {
        model.addAttribute("cust", customerService.getById(Integer.valueOf(id)));
        return "employee/customer/Detail";
    }

    @GetMapping("/read/{id}")
    public String read(@PathVariable("id") String id,
                         Model model) {
        model.addAttribute("customer", customerService.getById(Integer.valueOf(id)));
        return index(0,model);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") String id,
                         Model model) {
        Customer customer = customerService.getById(Integer.valueOf(id));
        customer.setStatus(false);
        customerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        model.addAttribute("customer", new Customer());
        return "redirect:/customer";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult result,
                       Model model) {
        if(result.hasErrors()){
            return index(0,model);
        }

        customer.setStatus(true);
        customerService.update(customer);
        return "redirect:/customer";
    }

}
