package com.example.cuongstarterkit.config.oauth.filter;

import com.example.cuongstarterkit.enums.ActivityType;
import com.example.cuongstarterkit.services.UserActivityService;
import com.example.cuongstarterkit.services.model.EsoftUserDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    UserActivityService userActivityService;

    // todo need investigate logout not working
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
        HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {

        EsoftUserDetails userDetails = (EsoftUserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        userActivityService.logActivity(username, ActivityType.LOGOUT_SUCCESS);

        log.info("logout success: " + username);
        super.onLogoutSuccess(request, response, authentication);
    }
}
