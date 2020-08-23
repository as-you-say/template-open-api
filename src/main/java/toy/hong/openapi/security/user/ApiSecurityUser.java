package toy.hong.openapi.security.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import toy.hong.openapi.model.ApiAuth;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

import java.util.stream.Collectors;

public class ApiSecurityUser extends User {


    public ApiSecurityUser(ApiUser apiUser) {
        super(
            apiUser.getUsername(),
            apiUser.getPassword(),
            AuthorityUtils.createAuthorityList(
                    apiUser.getApiUserAuths()
                            .stream()
                            .map(ApiUserAuth::getApiAuth)
                            .map(ApiAuth::getName)
                            .collect(Collectors.joining())
            )
        );
    }
}
