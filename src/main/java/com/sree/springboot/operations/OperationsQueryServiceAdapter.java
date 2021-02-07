package com.sree.springboot.operations;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class OperationsQueryServiceAdapter implements OperationsQueryService{

    private OperationsQueryRepository operationsQueryRepository;

    @Override
    public ResponseEntity<User> getUser(String userName) {
        return operationsQueryRepository.getUser(userName);
    }
}
