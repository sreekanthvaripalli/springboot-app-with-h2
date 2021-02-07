package com.sree.springboot.operations_adapter;

import com.sree.springboot.operations.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserJpaClient extends CrudRepository<User, Long> {

    @Query(
            value = "SELECT * FROM USERDETAIL WHERE USERDETAIL.name = ?1",
            nativeQuery = true
    )
    List<User> findUserByName(String userName);

    @Modifying
    @Query(
            value = "DELETE FROM USERDETAIL WHERE USERDETAIL.name = :userName",
            nativeQuery = true
    )
    int deleteUserByName(@Param("userName") String userName);
}
