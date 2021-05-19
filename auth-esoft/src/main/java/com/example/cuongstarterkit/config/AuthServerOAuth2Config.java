package com.example.cuongstarterkit.config;

import com.example.cuongstarterkit.config.encryption.Encoders;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
@Import(Encoders.class)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()")
            .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
            .withClient("client-esoft-backoffice").secret("{noop}123456")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "")
            .authorities("READ_ONLY_CLIENT")
            .scopes("read_profile_info", "openid")
            .resourceIds("oauth2-resource")
            .redirectUris("http://editor.local/login",
                "http://editor.local/login/oauth2/code/esoft",
                "http://editor.local/login/oauth2/code/articles-client-authorization-code",
                "http://editor.local/auth/login/oauth2/code/articles-client-authorization-code",
                "http://editor.local/oauth2/authorization/articles-client-authorization-code",
                "http://localhost:8085/login/oauth2/code/esoft"

            );
//            .accessTokenValiditySeconds(120)
//            .refreshTokenValiditySeconds(240000);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
    }
}

