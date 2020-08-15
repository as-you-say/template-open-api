package toy.hong.openapi.app.controller;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.hong.openapi.app.Response;

@RestController
public class ApiController {

    // OPEN API 등록
    @PostMapping("/manage/openapi")
    public ResponseEntity<Response> addAPI(){
        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

    // OPEN API 수정
    @PutMapping("/manage/openapi")
    public ResponseEntity<Response> modifyAPI(){
        return new ResponseEntity<>(new Response(
                200,
                "성공"
        ), HttpStatus.OK);
    }

    // OPEN API 삭제
    @DeleteMapping("/manage/openapi")
    public ResponseEntity<Response> removeAPI(){
        return new ResponseEntity<>(new Response(
                200,
                "성공"
        ), HttpStatus.OK);
    }

}
