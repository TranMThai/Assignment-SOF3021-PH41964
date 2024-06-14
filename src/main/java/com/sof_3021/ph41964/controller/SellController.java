package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Bill;
import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.entity.Customer;
import com.sof_3021.ph41964.entity.Employee;
import com.sof_3021.ph41964.entity.ProductDetail;
import com.sof_3021.ph41964.exception.InsufficientStockException;
import com.sof_3021.ph41964.service.BillDetailService;
import com.sof_3021.ph41964.service.BillService;
import com.sof_3021.ph41964.service.CustomerService;
import com.sof_3021.ph41964.service.EmployeeService;
import com.sof_3021.ph41964.service.ProductDetailService;
import com.sof_3021.ph41964.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sell")
@SessionAttributes("cart")
public class SellController {

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    BillService billService;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @ModelAttribute("cart")
    public List<ProductDetail> cart() {
        return new ArrayList<>();
    }

    @ModelAttribute("customers")
    public List<Customer> getCustomers() {
        return customerService.getAllActive();
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("productDetails", productDetailService.getAll());
        return "employee/sell/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("productDetails", productDetailService.search(search));
        return "employee/sell/Index";
    }

    @GetMapping("add")
    public String addToCart(@RequestParam("id") String id, @ModelAttribute("cart") List<ProductDetail> cart) {
        productDetailService.addToCart(cart, id);
        return "redirect:/sell";
    }

    @GetMapping("edit")
    public String ge(@RequestParam("id") String id,
                     @RequestParam("quantity") int quantity,
                     @ModelAttribute("cart") List<ProductDetail> cart) {
        productDetailService.editQuantityInCart(cart, id, quantity);
        return "redirect:/sell";
    }

    @GetMapping("remove")
    public String removeFromCart(@RequestParam("id") String id, @ModelAttribute("cart") List<ProductDetail> cart) {
        productDetailService.removeFromCart(cart, id);
        return "redirect:/sell";
    }

    @GetMapping("clear")
    public String clear(@ModelAttribute("cart") List<ProductDetail> cart) {
        cart.clear();
        return "redirect:/sell";
    }


    @Transactional
    @PostMapping("pay")
    public String pay(@SessionAttribute("cart") List<ProductDetail> cart,
                      @SessionAttribute("auth") Employee employee,
                      @RequestParam("customer") String customerId) {

        if (cart == null || cart.isEmpty() || employee == null) {
            return "redirect:/sell";
        }

        Bill bill = new Bill();
        bill.setEmployee(employeeService.getById(employee.getId()));
        if (!customerId.isEmpty()) {
            bill.setCustomer(customerService.getById(Integer.valueOf(customerId)));
        }
        bill.setPurchaseDate(new Date());
        bill.setStatus(true);

        billService.create(bill);

        cart.stream().forEach(productDetail -> {
            BillDetail billDetail = new BillDetail();
            billDetail.setBill(bill);
            billDetail.setProductDetail(productDetail);
            billDetail.setQuantity(productDetail.getQuantity());
            billDetail.setStatus(true);
            productDetailService.setQuantity(productDetail.getId(),productDetail.getQuantity());
            if(productDetailService.getById(productDetail.getId()).getQuantity()<0){
                throw new InsufficientStockException("Không thể mua nhiều hơn số lượng sản phẩm trong kho");
            }
            billDetailService.create(billDetail);
        });

        cart.clear();

        return "redirect:/sell";
    }
}
