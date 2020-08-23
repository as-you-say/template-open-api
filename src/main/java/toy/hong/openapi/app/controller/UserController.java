package toy.hong.openapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import toy.hong.openapi.app.Response;
import toy.hong.openapi.app.repositories.ApiAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserAuthRepository;
import toy.hong.openapi.app.repositories.ApiUserRepository;
import toy.hong.openapi.model.ApiAuth;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

@RestController
public class UserController {

    @Autowired
    ApiUserRepository apiUserRepository;

    @Autowired
    ApiAuthRepository apiAuthRepository;

    @Autowired
    ApiUserAuthRepository apiUserAuthRepository;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(ApiUser apiUser){
        String encryptPassword = new BCryptPasswordEncoder().encode(apiUser.getPassword());
        apiUser.setPassword(encryptPassword);

        ApiAuth apiAuth = apiAuthRepository.findByName("ROLE_USER");
        boolean isNotFoundAuth = (apiAuth == null);
        if (isNotFoundAuth) {
            ApiAuth authData = new ApiAuth();
            authData.setName("ROLE_USER");
            apiAuth = apiAuthRepository.save(authData);
        }

        ApiUserAuth apiUserAuth = new ApiUserAuth();
        apiUserAuth.setApiAuth(apiAuth);
        apiUserAuth.setApiUser(apiUserRepository.save(apiUser));
        apiUserAuthRepository.save(apiUserAuth);

        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

}
