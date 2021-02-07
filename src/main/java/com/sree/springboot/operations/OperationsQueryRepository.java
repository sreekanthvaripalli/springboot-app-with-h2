package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

public interface OperationsQueryRepository {
    ResponseEntity<User> getUser(String userName);
}
