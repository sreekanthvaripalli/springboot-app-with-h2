package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.OperationsQueryRepository;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class OperationsQueryAdapter implements OperationsQueryRepository {

    private UserJpaClient userJpaClient;

    @Override
    public ResponseEntity<User> getUser(String userName) {
        try {
            Optional<User> optionalUser = getUserByName(userName);
            return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(this::getFailureResponse);
        } catch (Exception e) {
            log.error("Exception occurred while fetching data", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            Optional<List<User>> userListOptional = getAllUsersFromDB();
            return userListOptional.map(users -> new ResponseEntity<>(users, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            log.error("Exception occurred while fetching all users", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Optional<List<User>> getAllUsersFromDB() {
        List<User> allUsers = (List<User>) userJpaClient.findAll();
        if (CollectionUtils.isEmpty(allUsers)) {
            log.error("returned empty result from DB");
            return Optional.empty();
        } else {
            log.info("number of users fetched : {}", allUsers.size());
            return Optional.of(allUsers);
        }
    }

    private ResponseEntity<User> getFailureResponse() {
        log.info("no user available with name");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Optional<User> getUserByName(String userName) {
        return userJpaClient.findUserByName(userName).stream().findFirst();
    }
}
