package toy.hong.openapi.security.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import toy.hong.openapi.model.ApiUser;

public class ApiSecurityUser extends User {
    public ApiSecurityUser(ApiUser apiUser) {
        super(
            apiUser.getId(),
            apiUser.getPassword(),
            AuthorityUtils.createAuthorityList(apiUser.getSecurityAuthArray())
        );
    }
}
