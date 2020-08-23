package toy.hong.openapi.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import toy.hong.openapi.app.repositories.ApiUserLogRepository;
import toy.hong.openapi.app.repositories.ApiUserRepository;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserLog;
import toy.hong.openapi.security.user.ApiSecurityUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ApiSecurityLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    ApiUserRepository apiUserRepository;

    @Autowired
    ApiUserLogRepository apiUserLogRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException, ServletException {
        ApiSecurityUser apiSecurityUser = (ApiSecurityUser)authentication.getPrincipal();
        ApiUser apiUser = apiUserRepository.findApiUserByUsername(apiSecurityUser.getUsername());

        ApiUserLog apiUserLog = new ApiUserLog();
        apiUserLog.setApiUser(apiUser);
        apiUserLog.setCreateAt(new Date());
        apiUserLog.setIp(req.getRemoteAddr());
        apiUserLog.setMessage("로그인");

        apiUserLogRepository.save(apiUserLog);
        res.sendRedirect("/");
    }
}