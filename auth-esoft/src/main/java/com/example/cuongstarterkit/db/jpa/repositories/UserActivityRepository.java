package com.example.cuongstarterkit.db.jpa.repositories;

import com.example.cuongstarterkit.db.jpa.entities.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
}
