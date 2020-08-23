package toy.hong.openapi.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import toy.hong.openapi.app.repositories.ApiAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserRepository;
import toy.hong.openapi.model.ApiAuth;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

import java.util.List;

public class ApiSecurityUserService implements UserDetailsService {

    @Autowired
    ApiAuthRepository apiAuthRepository;

    @Autowired
    ApiUserAuthRepository apiUserAuthRepository;

    @Autowired
    ApiUserRepository apiUserRepository;

    @Override
    public ApiSecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        // 권한 가져오기
        ApiUser apiUser = apiUserRepository.findApiUserByUsername(username);
        List<ApiUserAuth> apiUserAuths = apiUserAuthRepository.findAllByApiUser(apiUser);
        apiUserAuths.stream().forEach(e -> {
            ApiAuth apiAuth = apiAuthRepository.findOne(e.getApiAuth().getId());
            e.setApiAuth(apiAuth);
        });
        apiUser.setApiUserAuths(apiUserAuths);

        return new ApiSecurityUser(apiUser);
    }

}
