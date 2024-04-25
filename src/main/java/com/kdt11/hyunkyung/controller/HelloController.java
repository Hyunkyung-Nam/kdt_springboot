package com.kdt11.hyunkyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //ui로 되어있는거 추가하면된다.
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    class Hello{
        private int age;
        public Hello(int age){
            this.age = age;
        }
        public int getAge(){
            return age;
        }
    }

    class Person{
        private int age;
        private String name;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public int getAge(){
            return age;
        }
        public String getName(){
            return name;
        }
    }
    @GetMapping("/people")
    public String getHello(Model model){
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("kim", 10));
        people.add(new Person("lee", 20));
        people.add(new Person("home", 30));
        people.add(new Person("park", 40));
        people.add(new Person("shin", 50));

        model.addAttribute("people",people);
        return "people";
    }


    @GetMapping("/hi")
    public String getHi(Model model){
        //Model model  : Controller class안에 매서드가 파라미터로 받을 수 있는 객체
        model.addAttribute("msg", "hi~");
        model.addAttribute("uText", "<strong>Hello</strong>");
        model.addAttribute("value", "이름을 입력하세요");
        model.addAttribute("with","hello");
        model.addAttribute("link", "");
        model.addAttribute("img", "R0000452.JPG");
        model.addAttribute("userRole", "ddd");
        model.addAttribute("isAdmin", "false");


        List<String> names = Arrays.asList("홍길동", "성춘향", "임꺽정");
        model.addAttribute("names",names);

        Hello hello = new Hello(20);
        model.addAttribute("classHello",hello);

        model.addAttribute("age",20);




        //hi라는 템플릿을 쓸거야 라고 return한거임 . 그안에 들어가는데이터를 model을 이용해서 전달하는거
        //key value형태로 템플릿형태로 보내주는 것
        return "hi";
    }
}
