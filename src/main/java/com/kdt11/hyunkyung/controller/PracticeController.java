package com.kdt11.hyunkyung.controller;

import com.kdt11.hyunkyung.dtos.UserDto;
import com.kdt11.hyunkyung.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //실습 10번 : 회원관리 시스템
    private Map<String, UserDto> users = new HashMap<>();
    //키, 밸류 형태로  key로 userId, email등을 넣어주고 value로 userDto를 넣어준다.

    //회원가입
    @PostMapping("/practice10/register")
    @ResponseBody
    public String practice10Register(@RequestBody UserDto userDto){
        if(users.containsKey(userDto.getEmail())){
            return "이미 존재하는 이메일 입니다.";
        } else {
            users.put(userDto.getEmail(),userDto);
        }
        return "OK";
    }

    //로그인
    @PostMapping("/practice10/login")
    @ResponseBody
    public String practice10Login(@RequestBody UserDto userDto){
        UserDto exists = users.get(userDto.getEmail());
        if( exists != null && exists.getPassword().equals(userDto.getPassword())){
            return "OK";
        }
        return "Fail";
    }

    //수정
    @PutMapping("/practice10/{email}")
    @ResponseBody
    public String practicePut(@PathVariable("email") String email, @RequestBody UserDto userDto){
        if(!users.containsKey(email)){
            return "존재하지 않는 사용자 입니다.";
        }else {
            users.put(email, userDto);
            return "OK";
        }
    }

    @DeleteMapping("/practice10/{email}")
    @ResponseBody
    public String practiceDelete(@PathVariable("email") String email){
        if(!users.containsKey(email)){
            return "존재하지 않는 사용자 입니다.";
        }else {
            users.remove(email);
            return "OK";
        }
    }

}
