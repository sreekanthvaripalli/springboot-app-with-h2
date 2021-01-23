package com.sree.springboot.operations;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class OperationsCommandServiceAdapter implements OperationsCommandService{

    private OperationsCommandRepository operationsCommandRepository;

    @Override
    public ResponseEntity<String> saveUser(User user) {
        return operationsCommandRepository.saveUser(user);
    }
}
