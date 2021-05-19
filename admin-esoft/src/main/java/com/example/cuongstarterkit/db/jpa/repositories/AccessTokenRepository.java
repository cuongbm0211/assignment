package com.example.cuongstarterkit.db.jpa.repositories;

import com.example.cuongstarterkit.db.jpa.entities.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

}
