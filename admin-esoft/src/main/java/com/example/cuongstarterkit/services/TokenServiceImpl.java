package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.AccessToken;
import com.example.cuongstarterkit.db.jpa.repositories.AccessTokenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    AccessTokenRepository tokenRepository;

    @Override
    public List<AccessToken> listAccessTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public void revoke(String tokenId) {
        tokenRepository.deleteById(tokenId);
    }
}
