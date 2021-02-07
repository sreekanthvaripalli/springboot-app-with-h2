package com.sree.springboot.operations_resource;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "To perform CRUD operations through microservices")
@AllArgsConstructor
public class OperationsController {
    private OperationsHandler operationsHandler;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<String> saveDetails(
            @RequestBody UserRequest userRequest
    ){
        return operationsHandler.saveDetail(userRequest);
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<UserResponse> getUser(
            @RequestParam String userName
    ) {
        return operationsHandler.getUser(userName);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteUser(
            @RequestParam String userName
    ) {
        return operationsHandler.deleteUser(userName);
    }

    @PutMapping(value = "/administerUser")
    public ResponseEntity<String> administerUser(
            @RequestBody UserRequest userRequest
    ) {
        return operationsHandler.administerUser(userRequest);
    }
}
