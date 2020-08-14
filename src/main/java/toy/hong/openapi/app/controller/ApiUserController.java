package toy.hong.openapi.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUserController {
    @PostMapping("/openapi/apply")
    public void applyAPIUser(){
    }
    @GetMapping("/manage/openapi/apply")
    public void getAPIUserApplyList(){
    }
    @PutMapping("/manage/openapi/apply")
    public void approveAPIUserApply(){
    }
    @GetMapping("/manage/openapi/use")
    public void getAPIUserUseHistory(){
    }
}
