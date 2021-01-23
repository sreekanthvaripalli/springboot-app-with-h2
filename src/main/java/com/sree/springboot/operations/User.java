package com.sree.springboot.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class User {
    private String name;
    private Integer age;
    private String address;
    private String passportNumber;

    @Override
    public String toString(){
        return String.format("User : [name: %s, age: %s, address: %s, passportNumber: %s]", name, age, address, passportNumber);
    }
}
