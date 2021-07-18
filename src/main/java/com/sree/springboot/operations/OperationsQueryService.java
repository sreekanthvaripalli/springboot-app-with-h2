package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OperationsQueryService {
    ResponseEntity<User> getUser(String userName);
    ResponseEntity<List<User>> getAllUsers();
}
