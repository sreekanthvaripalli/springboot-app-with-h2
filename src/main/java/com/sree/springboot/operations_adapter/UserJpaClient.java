package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaClient extends JpaRepository<User, Long> {
}
