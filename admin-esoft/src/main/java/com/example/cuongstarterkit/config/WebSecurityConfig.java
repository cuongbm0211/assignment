package com.example.cuongstarterkit.config;

import com.example.cuongstarterkit.config.encryption.Encoders;
import com.example.cuongstarterkit.config.oauth.filter.LoginFailureHandler;
import com.example.cuongstarterkit.config.oauth.filter.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@Order(1)
@EnableWebSecurity
@Import(Encoders.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder userPasswordEncoder;

    @Autowired
    @Qualifier("esoftUserDetailService")
    UserDetailsService userDetailsService;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(userPasswordEncoder);

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/login", "/oauth/**").permitAll()
            .antMatchers("/css/**", "/js/**", "/assets/**", "/webjars/**").permitAll()
//            .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//            .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//            .antMatchers("/**").hasAuthority("ADMIN")
            .mvcMatchers("/**").hasAuthority("ADMIN")
            .mvcMatchers("/users/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("u").passwordParameter("p") // todo cuongbm: use for username
                .permitAll()
                .defaultSuccessUrl("/users")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
            .and()
            .logout()
            .logoutSuccessHandler(logoutSuccessHandler)
            .logoutSuccessUrl("/login")
            .permitAll()
            .and()
            .csrf().disable()
            .exceptionHandling().accessDeniedPage("/403");
    }

    //    https://stackoverflow.com/questions/49348551/could-not-autowire-authentication-manager-in-spring-boot-2-0-0/50163092
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
