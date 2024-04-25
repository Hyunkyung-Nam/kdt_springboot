package com.kdt11.hyunkyung.controller;

import com.kdt11.hyunkyung.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeController {


    @GetMapping("/prac1")
    public String checkAge(Model model){
        int age = 20;
        model.addAttribute("age", age);
        model.addAttribute("isMinor", age < 20);
        return "prac0425";
    }

    @GetMapping("/prac2")
    public String listPerson(Model model){
        List<Person> people= new ArrayList<>();
        people.add(new Person(10, "kim"));
        people.add(new Person(20, "lee"));
        people.add(new Person(30, "hong"));
        people.add(new Person(40, "park"));
        people.add(new Person(50, "shin"));

        model.addAttribute("people", people);

        return "prac0425_people";

    }
    //실습4 포스트 전송받기
    @GetMapping("/form")
    public String form(){
        return "form";

    }
    @PostMapping("/result")
    public String result(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String birthDate,
            @RequestParam List<String> interest,
            Model model
    ){
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("birthDate", birthDate);
        model.addAttribute("interests", String.join(", ",interest));
        return "result";
    }
}
