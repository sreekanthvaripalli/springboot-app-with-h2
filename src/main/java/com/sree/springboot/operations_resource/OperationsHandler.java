package com.sree.springboot.operations_resource;

import com.sree.springboot.operations.OperationsCommandService;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OperationsHandler {

    private OperationsCommandService operationsCommandService;

    public ResponseEntity<String> saveDetail(UserRequest userRequest) {
        return operationsCommandService.saveUser(getUser(userRequest));
    }

    private User getUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .passportNumber(userRequest.getPassportNumber())
                .build();
    }
}
