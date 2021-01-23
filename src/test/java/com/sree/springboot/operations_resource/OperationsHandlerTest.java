package com.sree.springboot.operations_resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class OperationsHandlerTest {

    @InjectMocks
    private OperationsHandler operationsHandler;

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowUnsupportedOperationException(){
        //Given

        //When
        ResponseEntity<String> stringResponseEntity = operationsHandler.saveDetail(mock(UserRequest.class));

        //Then
    }
}