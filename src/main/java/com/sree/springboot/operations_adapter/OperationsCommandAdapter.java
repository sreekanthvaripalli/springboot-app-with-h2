package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.OperationsCommandRepository;
import com.sree.springboot.operations.User;
import org.springframework.http.ResponseEntity;

public class OperationsCommandAdapter implements OperationsCommandRepository {
    @Override
    public ResponseEntity<String> saveUser(User user) {
        return null;
    }
}
