package com.sree.springboot.operations_resource;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}