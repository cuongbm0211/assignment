package com.example.cuongstarterkit.db.jpa.repositories;

import com.example.cuongstarterkit.db.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    // todo cuongbm we can improve use jpa query
//    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByUsername(String username);

}
