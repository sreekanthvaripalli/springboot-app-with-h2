package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.OperationsCommandRepository;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OperationsCommandAdapter implements OperationsCommandRepository {

    private UserJpaClient userJpaClient;

    @Override
    public ResponseEntity<String> saveUser(User user) {
        User save = userJpaClient.save(user);
        if (save != null) {
            return ResponseEntity.of(Optional.of("Success"));
        }
        return ResponseEntity.of(Optional.of("Failed to save"));
    }
}
