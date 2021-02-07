package com.sree.springboot.operations_resource;

import com.sree.springboot.operations.OperationsCommandService;
import com.sree.springboot.operations.OperationsQueryService;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OperationsHandler {

    private OperationsCommandService operationsCommandService;
    private OperationsQueryService operationsQueryService;

    public ResponseEntity<String> saveDetail(UserRequest userRequest) {
        return operationsCommandService.saveUser(getUser(userRequest));
    }

    private User getUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .build();
    }

    public ResponseEntity<UserResponse> getUser(String userName) {
        ResponseEntity<User> user = operationsQueryService.getUser(userName);
        ResponseEntity<?> responseEntity = user.getStatusCodeValue() == 200 ? getMappedResponse(user.getBody()) : user;
        return (ResponseEntity<UserResponse>) responseEntity;
    }

    private ResponseEntity<UserResponse> getMappedResponse(User user) {

        return new ResponseEntity<UserResponse>(UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(String userName) {
        return operationsCommandService.deleteUser(userName);
    }

    public ResponseEntity<String> administerUser(UserRequest userRequest) {
        return operationsCommandService.administerUSer(getUser(userRequest));
    }
}
