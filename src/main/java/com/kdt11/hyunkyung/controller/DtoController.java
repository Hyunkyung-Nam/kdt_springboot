package com.kdt11.hyunkyung.controller;

import com.kdt11.hyunkyung.dtos.UserDto;
import com.kdt11.hyunkyung.vos.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DtoController {
    //페이지 먼저 열어주고
    @GetMapping("/dto")
    public String dto(){
        return "dto";

    }
    @GetMapping("/axios")
    public String axiosPage(){
        return "axios";
    }

    //해당페이지에서 요청하는거 API해주고
    @GetMapping("/dto/response1")
    // return 할 때 "/dto/response1"로 페이지 이동하고 데이터 잘 나온다.
    @ResponseBody
    public String dtoResponse1(@ModelAttribute UserDto userDto, Model model){

//        model.addAttribute("name", userDto.getName());
//        model.addAttribute("age", userDto.getAge());
 //       return "API";
        String msg = userDto.getName() + " " + userDto.getAge();

        return msg;
    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoResponse2(@ModelAttribute UserDto userDto, Model model){
//        model.addAttribute("name", userDto.getName());
//        model.addAttribute("age", userDto.getAge());

        String msg = userDto.getName() + " " + userDto.getAge();
        return msg;
    }

    @PostMapping("/dto/response3")
    @ResponseBody
    public String dtoResponse3(@RequestBody UserDto userDto, Model model){
//        model.addAttribute("name", userDto.getName());
//        model.addAttribute("age", userDto.getAge());
//
//        return "API";
        String msg = userDto.getName() + " " + userDto.getAge();
        return msg;
    }

    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value = "name")String name,@RequestParam(value = "age") String age){
        String msg = "이름 : "+ name + "\n나이 : " + age;
        return msg;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosAPI2(UserDto userDto){
        String msg = "이름 : "+userDto.getName() + "\n나이 : "+ userDto.getAge();
        return msg;
    }

    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value="name") String name, @RequestParam(value = "age") String age){
        String msg = "이름 : "+ name + "\n나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosAPI4(UserDto userDto){
        String msg = "이름 : "+userDto.getName() + "\n나이 : "+ userDto.getAge();
        return msg;
    }

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosAPI5(@RequestBody UserDto userDto){
        String msg = "이름 : "+userDto.getName() + "\n나이 : "+ userDto.getAge();
        return msg;
    }


}
