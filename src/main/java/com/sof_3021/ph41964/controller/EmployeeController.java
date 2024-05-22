package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.BillDetail;
import com.sof_3021.ph41964.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    BillDetailService service;

    @ResponseBody
    @GetMapping("")
    public String index(){
        return "ok";
    }
}
