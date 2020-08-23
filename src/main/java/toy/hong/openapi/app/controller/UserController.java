package toy.hong.openapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import toy.hong.openapi.app.Response;
import toy.hong.openapi.app.repositories.ApiUserRepository;
import toy.hong.openapi.model.ApiUser;

@RestController
public class UserController {

    @Autowired
    ApiUserRepository apiUserRepository;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(ApiUser apiUser){
        String encryptPassword = new BCryptPasswordEncoder().encode(apiUser.getPassword());
        apiUser.setPassword(encryptPassword);
        apiUserRepository.save(apiUser);

        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

}
