package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Bill;
import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.service.BillDetailService;
import com.sof_3021.ph41964.service.BillService;
import com.sof_3021.ph41964.service.CustomerService;
import com.sof_3021.ph41964.service.EmployeeService;
import com.sof_3021.ph41964.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BillService billService;

    @Autowired
    BillDetailService billDetailService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list", billService.getAllActive());
        return "admin/bill/Index";
    }

    @Transactional
    @GetMapping("/remove")
    public String remove(@RequestParam("id") int id) {
        List<BillDetail> billDetailList = billService.getById(id).getBillDetails();
        billDetailList.stream()
                .forEach(billDetail -> {
                    billDetail.setStatus(false);
                    billDetailService.update(billDetail);
                });

        Bill bill = billService.getById(id);
        bill.setStatus(false);
        billService.update(bill);
        return "redirect:/bill";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id,
                         Model model) {
        model.addAttribute("bill", billService.getById(id));
        return "admin/bill/Detail";
    }


    @GetMapping("/search")
    public String search(@RequestParam("search") String search,
                         Model model) {
        try {
            if (search != null && !search.trim().isEmpty()) {
                Integer searchInt = Integer.valueOf(search);
                model.addAttribute("list", billService.search(searchInt));
                return "admin/bill/Index";
            }
        } catch (NumberFormatException e) {
        }
        return "redirect:/bill";
    }

    @ModelAttribute("employees")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @ModelAttribute("customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") int id,
                             Model model) {
        model.addAttribute("bill", billService.getById(id));
        return "admin/bill/Update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("bill") Bill bill,
                         @ModelAttribute("purchaseDate") String date,
                         Model model) {
        bill.setPurchaseDate(DateUtils.parseDate(date));
        billService.update(bill);
        return "redirect:/bill";
    }

}
