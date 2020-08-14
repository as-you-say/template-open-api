package toy.hong.openapi.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @PostMapping("/manage/openapi")
    public void addAPI(){
    }
    @PutMapping("/manage/openapi")
    public void modifyAPI(){
    }
    @DeleteMapping("/manage/openapi")
    public void removeAPI(){
    }
}
