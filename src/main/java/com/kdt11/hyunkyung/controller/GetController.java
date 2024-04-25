package com.kdt11.hyunkyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
//RESTController를 어노테이션을 사용하면 더 이상 템플릿을 사용하는 것이 아닌 데이터를 출력하는것
public class GetController {
    @GetMapping("/greet")
    //@ResponseBody
    public String greeting(@RequestParam(name="abc",required = false, defaultValue = "안녕하세요") String abc,
                           @RequestParam(name="xyz",required = false, defaultValue = "안녕히가세요") String xyz,
                           Model model){
        //여기있는 메소드 명은 큰 의미가 없다.

        model.addAttribute("name", abc);
        model.addAttribute("name2", xyz);

        //@ResponseBody이걸 넣으면 String값이 넘어가고 저게 없으면 템플릿 greet을 연다.
        return "greet";
    }

    @GetMapping("/greets/{value}/{abc}")
    public String greetsing(@PathVariable String value,@PathVariable("abc") String zyx, Model model){
        model.addAttribute("name", value);
        model.addAttribute("name2", zyx);
        return "greet";
    }


    @GetMapping("/rest")
    public String rest(@RequestParam String value){
        return "Hello" + value;
    }
}
