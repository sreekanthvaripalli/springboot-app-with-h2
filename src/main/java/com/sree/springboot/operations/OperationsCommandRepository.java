package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

public interface OperationsCommandRepository {

    ResponseEntity<String> saveUser(User user);
    ResponseEntity<String> deleteUser(String userName);
}
