package com.kdt11.hyunkyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @GetMapping("/post")
    public String getPost(Model model){
        return "index";
    }
    @PostMapping("mvc-post")
    public String postMVC(
            @RequestParam(value="name") String name,
            @RequestParam(value="age") String age,
            Model model){

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "API";
    }
}
