package toy.hong.openapi.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import toy.hong.openapi.app.repositories.ApiUserRepository;

public class ApiSecurityUserService implements UserDetailsService {

    @Autowired
    ApiUserRepository apiUserRepository;

    @Override
    public ApiSecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ApiSecurityUser(apiUserRepository.findApiUserByUsername(username));
    }

}
