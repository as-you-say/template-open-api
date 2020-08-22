package toy.hong.openapi.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import toy.hong.openapi.app.repositories.ApiUserLogRepository;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserLog;
import toy.hong.openapi.security.user.ApiSecurityUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ApiSecurityLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    ApiUserLogRepository apiUserLogRepository;

    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException, ServletException {
        ApiUser apiUser = new ApiUser();
        apiUser.setId(((ApiSecurityUser)authentication.getPrincipal()).getUsername());

        ApiUserLog apiUserLog = new ApiUserLog();
        apiUserLog.setApiUser(apiUser);
        apiUserLog.setCreateAt(new Date());
        apiUserLog.setIp(req.getRemoteAddr());
        apiUserLog.setMessage("로그아웃");

        apiUserLogRepository.save(apiUserLog);
        res.sendRedirect("/login");
    }
}
