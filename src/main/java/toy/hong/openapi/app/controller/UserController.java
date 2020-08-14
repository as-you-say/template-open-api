package toy.hong.openapi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // 로그인
    @PostMapping("/login")
    public void login(){
    }

    // 회원가입
    @PostMapping("/signup")
    public void signup(){
    }

}
