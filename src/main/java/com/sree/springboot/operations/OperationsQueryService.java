package com.sree.springboot.operations;

import org.springframework.http.ResponseEntity;

public interface OperationsQueryService {
    ResponseEntity<User> getUser(String userName);
}
