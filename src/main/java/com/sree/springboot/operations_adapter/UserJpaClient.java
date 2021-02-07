package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaClient extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT * FROM USERDETAIL WHERE USERDETAIL.name = ?1",
            nativeQuery = true
    )
    List<User> findUserByName(String userName);
}
