package toy.hong.openapi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/login")
    public void login(){

    }

    @PostMapping("/signup")
    public void signup(){

    }
}
