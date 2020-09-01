package toy.hong.openapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.hong.openapi.app.Response;
import toy.hong.openapi.app.service.ApiService;
import toy.hong.openapi.model.Api;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    // OPEN API 등록
    @PostMapping("/manage/openapi")
    public ResponseEntity<Response> addAPI(Api api){
        apiService.addAPI(api);
        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

    // OPEN API 수정
    @PutMapping("/manage/openapi")
    public ResponseEntity<Response> modifyAPI(Api api){
        apiService.modifyAPI(api);
        return new ResponseEntity<>(new Response(
                200,
                "성공"
        ), HttpStatus.OK);
    }

    // OPEN API 삭제
    @DeleteMapping("/manage/openapi")
    public ResponseEntity<Response> removeAPI(Api api){
        apiService.removeAPI(api);
        return new ResponseEntity<>(new Response(
                200,
                "성공"
        ), HttpStatus.OK);
    }

}
