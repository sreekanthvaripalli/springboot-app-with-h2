package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OperationsQueryRepository {
    ResponseEntity<User> getUser(String userName);

    ResponseEntity<List<User>> getAllUsers();
}
