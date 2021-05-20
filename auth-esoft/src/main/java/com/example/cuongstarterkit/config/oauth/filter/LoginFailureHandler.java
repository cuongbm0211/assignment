package com.example.cuongstarterkit.config.oauth.filter;

import static com.example.cuongstarterkit.enums.ActivityType.LOGIN_FAILURE;

import com.example.cuongstarterkit.services.UserActivityService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    UserActivityService userActivityService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {

        String userName = request.getParameter("u");
        log.info("User login failure: " + userName);

        userActivityService.logActivity(userName, LOGIN_FAILURE);

        String redirectURL = "/login_error?error&email=" + userName;
        super.setDefaultFailureUrl(redirectURL);
        super.onAuthenticationFailure(request, response, exception);
    }
}
