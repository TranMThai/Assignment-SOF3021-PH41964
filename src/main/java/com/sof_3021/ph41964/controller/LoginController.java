package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.dto.AccountDTO;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("auth", new AccountDTO());
        return "Login";
    }

    @PostMapping("/enter")
    public String login(@ModelAttribute("auth") AccountDTO account,
                        RedirectAttributes redirAttr,
                        HttpSession session) {
        Employee employee = employeeService.login(account);
        if (employee != null) {
            session.setAttribute("auth", employee);
            if (employee.getRole()) {
                return "redirect:/admin/product";
            } else {
                return "redirect:/sell";
            }
        }
        redirAttr.addFlashAttribute("message", "Sai tài khoản hoặc mật khẩu");
        return "redirect:/login";
    }

}
