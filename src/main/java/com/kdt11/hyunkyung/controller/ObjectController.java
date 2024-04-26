package com.kdt11.hyunkyung.controller;

import com.kdt11.hyunkyung.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ObjectController {
    @GetMapping("/dtoform")
    public String dtoForm(){
        return "dtoform";
    }
//    @GetMapping("/user1")
//    public String user1(Model model ){
//        //Dto를 사용안한다고 가정
//
////        UserDto noDto = new UserDto("홍길동", "abc@ab.com", 20);
////        model.addAttribute("name", noDto.getName());
////        model.addAttribute("email", noDto.getEmail());
////        model.addAttribute("age", noDto.getAge());
//
//
//        //Dto를 사용한다고 가정
//        UserDto user = new UserDto("성춘향", "xyz@ab.com", 20);
//        model.addAttribute("user", user);
//
//        return "user" ;
//    }

    @PostMapping("/user1")
    public String postUser(@ModelAttribute UserDto userDto, Model model){
        model.addAttribute("user", userDto);
        return "user";
    }
}
