package com.kdt11.hyunkyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracticeGetController {
    @GetMapping("/introduce/{name}")
    public String introduce(@PathVariable String name, Model model){
        model.addAttribute("isIntroduce2", false);
        model.addAttribute("name", name);
        return "introduce";
    }
    @GetMapping("/introduce2")
    public String introduce2(@RequestParam(name="name") String name, @RequestParam(name="age") String age, Model model){
        model.addAttribute("isIntroduce2", true);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "introduce";
    }
}
