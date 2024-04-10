package com.sree.springboot.spring_adapter;

import com.sree.springboot.operations.OperationsCommandRepository;
import com.sree.springboot.operations.OperationsCommandService;
import com.sree.springboot.operations.OperationsCommandServiceAdapter;
import com.sree.springboot.operations.OperationsQueryRepository;
import com.sree.springboot.operations.OperationsQueryService;
import com.sree.springboot.operations.OperationsQueryServiceAdapter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class OperationsConfiguration {

    @Bean
    public OperationsCommandService operationsCommandService(
            OperationsCommandRepository operationsCommandRepository
    ) {
        return new OperationsCommandServiceAdapter(operationsCommandRepository);
    }

    @Bean
    public OperationsQueryService operationsQueryService(
            OperationsQueryRepository operationsQueryRepository
    ) {
        return new OperationsQueryServiceAdapter(operationsQueryRepository);
    }
}
