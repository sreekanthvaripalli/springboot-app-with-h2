package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.OperationsCommandRepository;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
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

    @Override
    public ResponseEntity<String> deleteUser(String userName) {
        log.info("username: {}", userName);
        try {
            int deletedRecords = userJpaClient.deleteUserByName(userName);
            return (deletedRecords > 0) ? new ResponseEntity<>("Success", HttpStatus.OK)
                    : new ResponseEntity<>("Record not available", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("exception so failed - return failure");
            return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> administerUser(User user) {
        //find user if available or not
        List<User> existingUser = userJpaClient.findUserByName(user.getName());
        if(existingUser.isEmpty()){
            return new ResponseEntity<>("User not found in DB", HttpStatus.NOT_FOUND);
        }
        //Currently taking first record to update
        user.setId(existingUser.get(0).getId());
        User updatedUser = userJpaClient.save(user);
        if (updatedUser != null) {
            return new ResponseEntity<>("User detail updated in DB", HttpStatus.OK);
        }
        return ResponseEntity.of(Optional.of("Failed to update user details"));
    }
}
