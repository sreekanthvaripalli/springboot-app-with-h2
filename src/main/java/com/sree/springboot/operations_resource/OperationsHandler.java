package com.sree.springboot.operations_resource;

import com.sree.springboot.operations.OperationsCommandService;
import com.sree.springboot.operations.OperationsQueryService;
import com.sree.springboot.operations.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        return new ResponseEntity<UserResponse>(getBuiltUser(user), HttpStatus.OK);
    }

    private UserResponse getBuiltUser(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .build();
    }

    public ResponseEntity<String> deleteUser(String userName) {
        return operationsCommandService.deleteUser(userName);
    }

    public ResponseEntity<String> administerUser(UserRequest userRequest) {
        return operationsCommandService.administerUSer(getUser(userRequest));
    }

    public ResponseEntity<List<UserResponse>> getAllUsers() {
        ResponseEntity<List<User>> allUsers = operationsQueryService.getAllUsers();
        ResponseEntity<?> responseEntity = allUsers.getStatusCodeValue() == 200 ? getUsersResponse(allUsers.getBody()) : allUsers;
        return (ResponseEntity<List<UserResponse>>) responseEntity;
    }

    private ResponseEntity<List<UserResponse>> getUsersResponse(List<User> users) {
        List<UserResponse> usersList = users.stream().map(this::getBuiltUser).collect(Collectors.toList());
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
}
