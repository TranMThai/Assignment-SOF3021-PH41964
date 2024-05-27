package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Size;
import com.sof_3021.ph41964.service.SizeService;
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
@RequestMapping("/size")
public class SizeController {

    @Autowired
    SizeService sizeService;

    @ModelAttribute("size")
    public Size getSize(){
        return new Size();
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list",sizeService.getAllActive());
        return "employee/size/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search,
                         Model model){
        model.addAttribute("list",sizeService.search(search));
        return "employee/size/Index";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") String id){
        Size size = sizeService.getById(Integer.valueOf(id));
        size.setStatus(false);
        sizeService.update(size);
        return "redirect:/size";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model){
        model.addAttribute("size",sizeService.getById(Integer.valueOf(id)));
        return index(model);
    }

    @GetMapping("clear")
    public String clear(Model model){
        model.addAttribute("size",new Size());
        return "redirect:/size";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("size") Size size,
                       BindingResult result,
                       Model model){
        if(result.hasErrors()){
            return index(model);
        }
        size.setStatus(true);
        sizeService.update(size);
        return "redirect:/size";
    }
}
