package com.sree.springboot.operations_resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserRequest {
    private String name;
    private Integer age;
    private String address;
}
