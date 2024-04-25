package com.kdt11.hyunkyung.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private int age;

    public UserDto(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
