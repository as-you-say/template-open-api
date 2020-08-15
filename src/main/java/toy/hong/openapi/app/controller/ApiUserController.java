package toy.hong.openapi.app.controller;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.hong.openapi.app.Response;
import toy.hong.openapi.model.ApiUseApply;
import toy.hong.openapi.model.ApiUseHistory;
import toy.hong.openapi.model.ApiUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiUserController {

    // OPEN API 사용 신청
    @PostMapping("/openapi/apply")
    public ResponseEntity<Response> applyAPIUser(){
        return new ResponseEntity<>(new Response(
                201,
                "성공"
        ), HttpStatus.CREATED);
    }

    // OPEN API 신청 현황 조회
    @GetMapping("/manage/openapi/apply")
    public ResponseEntity<Response> getAPIUseApplyList(){
        Map<String, Object> data = new HashMap<>();
        return new ResponseEntity<>(new Response(
                200,
                "성공",
                data
        ), HttpStatus.OK);
    }

    // OPEN API 신청 승인
    @PutMapping("/manage/openapi/apply")
    public ResponseEntity<Response> approveAPIUserApply(){
        return new ResponseEntity<>(new Response(
                200,
                "성공"
        ), HttpStatus.OK);
    }

    // OPEN API 사용 이력 조회
    @GetMapping("/manage/openapi/use")
    public ResponseEntity<Response> getAPIUserUseHistory(){
        Map<String, Object> data = new HashMap<>();
        return new ResponseEntity<>(new Response(
                200,
                "성공",
                data
        ), HttpStatus.OK);
    }

}
