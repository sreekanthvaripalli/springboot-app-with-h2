package com.sree.springboot.operations_resource;

import com.sree.springboot.operations.OperationsCommandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperationsHandlerTest {

    @InjectMocks
    private OperationsHandler operationsHandler;

    @Mock
    private OperationsCommandService operationsCommandService;

    @Test
    public void testShouldSaveUser(){
        //Given
        UserRequest userRequest = UserRequest.builder()
                .name("sree")
                .age(27)
                .address("KKD")
                .build();
        Optional<String> body = Optional.of("Success");
        when(operationsCommandService.saveUser(any())).thenReturn(ResponseEntity.of(body));

        //When
        ResponseEntity<String> stringResponseEntity = operationsHandler.saveDetail(userRequest);

        //Then
        assertNotNull(stringResponseEntity);
        assertEquals(body.get(), stringResponseEntity.getBody());
    }
}