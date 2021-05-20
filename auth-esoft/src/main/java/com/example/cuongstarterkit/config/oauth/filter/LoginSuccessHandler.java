package com.example.cuongstarterkit.config.oauth.filter;

import static com.example.cuongstarterkit.enums.ActivityType.LOGIN_SUCCESS;

import com.example.cuongstarterkit.services.UserActivityService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    UserActivityService userActivityService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws ServletException, IOException {

        String username = authentication.getName();
        logger.info("Logged user: " + username);
        userActivityService.logActivity(username, LOGIN_SUCCESS);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
