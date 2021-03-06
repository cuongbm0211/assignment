package com.example.cuongstarterkit.db.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity(name = "oauth_access_token")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AccessToken implements Serializable {

    @Id
    @Column(name = "token_id")
    private String id;

    private String authenticationId;
    private String userName;
    private String clientId;
    private String refreshToken;
}
