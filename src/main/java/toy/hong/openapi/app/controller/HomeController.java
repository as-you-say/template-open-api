package toy.hong.openapi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goHome(){
        return "home";
    }

    // 로그인
    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    // 로그인
    @GetMapping("/signUp")
    public String goSignUp(){
        return "signUp";
    }

}
