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
import toy.hong.openapi.app.service.UserService;
import toy.hong.openapi.model.ApiAuth;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 회원가입
    @PostMapping("/signUp")
    public ResponseEntity<Response> signUp(ApiUser apiUser){
        userService.signUp(apiUser);
        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

}
