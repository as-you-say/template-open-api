package toy.hong.openapi.app.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    // OPEN API 등록
    @PostMapping("/manage/openapi")
    public void addAPI(){
    }

    // OPEN API 수정
    @PutMapping("/manage/openapi")
    public void modifyAPI(){
    }

    // OPEN API 삭제
    @DeleteMapping("/manage/openapi")
    public void removeAPI(){
    }

}
