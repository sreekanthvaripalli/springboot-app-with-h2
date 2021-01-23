package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

public interface OperationsCommandService {
    ResponseEntity<String> saveUser(User user);
}
