package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.model.Account;
import com.sof_3021.ph41964.model.EmployeeInfo;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String index(@RequestParam(name = "page", defaultValue = "0") Integer page,
                        Model model) {
        model.addAttribute("list", employeeService.getByPageActive(page));
        model.addAttribute("url", "/employee?");
        return "employee/employee/Index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "page", defaultValue = "0") Integer page,
                         @RequestParam("search") String search,
                         Model model) {
        model.addAttribute("list", employeeService.search(page,search));
        model.addAttribute("url", "/employee?search="+search+"&");
        return "employee/employee/Index";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") String id) {
        Employee employee = employeeService.getById(Integer.valueOf(id));
        employee.setStatus(false);
        employeeService.update(employee);
        return "redirect:/employee";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model) {
        Employee employee = employeeService.getById(Integer.valueOf(id));
        model.addAttribute("employee", new EmployeeInfo(employee));
        return "employee/employee/Detail";
    }

    @PostMapping("/update")
    public String updateInfo(@Valid @ModelAttribute("employee") EmployeeInfo employeeInfo,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "employee/employee/Detail";
        }
        Employee employee = employeeService.infoToEntity(employeeInfo);
        employeeService.update(employee);
        return "redirect:/employee";
    }

    @GetMapping("/change_password/{id}")
    public String viewChangePassword(@PathVariable("id") String id,
                                     Model model) {
        Account account = new Account(employeeService.getById(Integer.valueOf(id)));
        model.addAttribute("account", account);
        return "employee/employee/ChangePassword";
    }

    @PostMapping("/change_password")
    public String updateAccount(@Valid @ModelAttribute("account") Account account,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "employee/employee/ChangePassword";
        }
        Employee employee = employeeService.accountToEntity(account);
        employeeService.update(employee);
        return "redirect:/employee";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employee/Create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "employee/employee/Create";
        }
        employee.setStatus(true);
        employeeService.create(employee);
        return "redirect:/employee";
    }

}

