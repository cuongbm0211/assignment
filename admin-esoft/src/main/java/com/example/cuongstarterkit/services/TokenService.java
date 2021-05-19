package com.example.cuongstarterkit.services;

import com.example.cuongstarterkit.db.jpa.entities.AccessToken;
import java.util.List;

public interface TokenService {

    List<AccessToken> listAccessTokens();

    void revoke(String tokenId);
}
