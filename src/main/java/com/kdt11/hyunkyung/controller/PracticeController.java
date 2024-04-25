package com.kdt11.hyunkyung.controller;

import com.kdt11.hyunkyung.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}