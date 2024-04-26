package com.kdt11.hyunkyung.controller;


import com.kdt11.hyunkyung.dtos.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private List<User> members = new ArrayList<>();
    //페이지
    //회원가입 페이지
    @GetMapping("/register")
    public String registerPage(){
        return "User/register";
    }
    //로그인 페이지
    @GetMapping("/login")
    public String loginPage(){
        return "User/login";
    }
    //회원정보 수정
    @GetMapping("/member")
    public String updateMemberPage(){
        return "User/update_user_info";
    }

    //컨트롤러
    //회원가입
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        members.add(user);
        return user.getName()+"성공";
    }
    //로그인
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user){

        String success = "실패";
        for(User member :members){

            if(member.getUserId().equals(user.getUserId()) && member.getUserPw().equals(user.getUserPw()) ) {
                success = "성공";
            }
        }
        return  success ;
    }
    //회원조회
    @GetMapping("/member/{value}")
    @ResponseBody
    public User findMember(@PathVariable String value){

        return members.get(0);
    }
    //회원정보 수정
    @PatchMapping("/member")
    @ResponseBody
    public String updateMember(@RequestBody User user){
        members.clear();
        members.add(user);

        return "success";
    }

    //회원 탈퇴
    @DeleteMapping("/member")
    @ResponseBody
    public String deleteMember(@RequestBody User user){
        members.clear();
        return "deleteMember";
    }
}
