package com.sof_3021.ph41964.controller;

import com.sof_3021.ph41964.entity.Color;
import com.sof_3021.ph41964.service.ColorService;
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
@RequestMapping("/color")
public class ColorController {

    @Autowired
    ColorService colorService;

    @ModelAttribute("color")
    public Color getColor(){
        return new Color();
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("list",colorService.getAllActive());
        return "employee/color/Index";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search,
                         Model model){
        model.addAttribute("list",colorService.search(search));
        return "employee/color/Index";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") String id){
        Color color = colorService.getById(Integer.valueOf(id));
        color.setStatus(false);
        colorService.update(color);
        return "redirect:/color";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id,
                       Model model){
        model.addAttribute("color",colorService.getById(Integer.valueOf(id)));
        return index(model);
    }

    @GetMapping("clear")
    public String clear(Model model){
        model.addAttribute("color",new Color());
        return "redirect:/color";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("color") Color color,
                       BindingResult result,
                       Model model){
        if(result.hasErrors()){
            return index(model);
        }
        color.setStatus(true);
        colorService.update(color);
        return "redirect:/color";
    }

}
