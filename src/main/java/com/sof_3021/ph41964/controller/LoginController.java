package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.model.Account;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("auth", new Account());
        return "Login";
    }

    @PostMapping("/login/enter")
    public String login(@ModelAttribute("auth") Account account,
                        RedirectAttributes redirAttr,
                        HttpSession session) {
        Employee employee = employeeService.login(account);
        if (employee != null) {
            session.setAttribute("auth", employee);
            return "redirect:/sell";
        }
        redirAttr.addFlashAttribute("message", "Sai tài khoản hoặc mật khẩu");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("auth", null);
        return "redirect:/login";
    }
}
