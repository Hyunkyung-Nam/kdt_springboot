package com.kdt11.hyunkyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PracticePostController {
    @GetMapping("/pracpost")
    public String practicePost(Model model){
        return "prac_post";
    }

    @PostMapping("prac-post")
    public String practicePost(@RequestParam(name="name" )String name,
                               @RequestParam(name="gender")String gender,
                               @RequestParam(name="birth")String birth,
                               @RequestParam(name="interested",required = false) String[] interested,
                               Model model){

        List<String> seleted = new ArrayList<>();

        if(interested != null){

            for(String interest:interested) {
                switch (interest) {
                    case "fassion":
                        seleted.add("패션");
                        break;
                    case "food":
                        seleted.add("음식");
                        break;
                    case "travel":
                        seleted.add("여행");
                        break;
                }
            }
        }

        model.addAttribute("name", name);

        if( gender.equals("male")){
            model.addAttribute("isMale", true);
        } else {
            model.addAttribute("isMale", false);
        }
        model.addAttribute("birth", birth);
        model.addAttribute("interested", seleted);

        return "API";
    }
}
