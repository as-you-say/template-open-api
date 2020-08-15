package toy.hong.openapi.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.hong.openapi.app.Response;

@RestController
public class UserController {

    // 로그인
    @PostMapping("/login")
    public void login(){
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(){
        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

}
