package com.example.cuongstarterkit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("user/list-users");
        registry.addViewController("/users/add-user").setViewName("user/add-user");
//        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/loginerror").setViewName("login_error");
        registry.addViewController("/cpanel").setViewName("cpanel");
        registry.addViewController("/403").setViewName("403");
    }
}
