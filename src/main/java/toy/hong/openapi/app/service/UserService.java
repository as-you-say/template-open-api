package toy.hong.openapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.hong.openapi.app.repositories.ApiAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserRepository;
import toy.hong.openapi.app.service.validation.UserValidationService;
import toy.hong.openapi.model.ApiAuth;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

@Service
public class UserService extends UserValidationService {
    @Autowired
    ApiUserRepository apiUserRepository;

    @Autowired
    ApiAuthRepository apiAuthRepository;

    @Autowired
    ApiUserAuthRepository apiUserAuthRepository;

    @Transactional
    public void signUp(ApiUser apiUser){
        // 밸리데이션 체크
        validateSignUp(apiUser);

        // 패스워드 인코딩
        String encryptPassword = new BCryptPasswordEncoder().encode(apiUser.getPassword());
        apiUser.setPassword(encryptPassword);

        // 권한 없을시 생성
        ApiAuth apiAuth = apiAuthRepository.findByName("ROLE_USER");
        boolean isNotFoundAuth = (apiAuth == null);
        if (isNotFoundAuth) {
            ApiAuth authData = new ApiAuth();
            authData.setName("ROLE_USER");
            apiAuth = apiAuthRepository.save(authData);
        }

        // 회원가입
        ApiUserAuth apiUserAuth = new ApiUserAuth();
        apiUserAuth.setApiAuth(apiAuth);
        apiUserAuth.setApiUser(apiUserRepository.save(apiUser));
        apiUserAuthRepository.save(apiUserAuth);
    }

}
