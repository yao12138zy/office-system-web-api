package com.springboot.officesystem.repository;
import com.springboot.officesystem.model.Request;
import com.springboot.officesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.accountType = false")
    public List<User> getUserAccounts ();

    @Query("SELECT u FROM User u WHERE u.accountType = true")
    public List<User> getManagerAccounts ();



}
