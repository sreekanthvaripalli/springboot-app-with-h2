package com.sree.springboot.spring_adapter;

import com.sree.springboot.operations.OperationsCommandRepository;
import com.sree.springboot.operations.OperationsCommandService;
import com.sree.springboot.operations.OperationsCommandServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationsConfiguration {

    @Bean
    public OperationsCommandService operationsCommandService(
            OperationsCommandRepository operationsCommandRepository
    ){
        return new OperationsCommandServiceAdapter(operationsCommandRepository);
    }
}
