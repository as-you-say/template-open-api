package toy.hong.openapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.hong.openapi.app.Response;
import toy.hong.openapi.app.repositories.ApiUseApplyRepository;
import toy.hong.openapi.app.repositories.ApiUseHistoryRepository;
import toy.hong.openapi.app.service.ApiUserService;
import toy.hong.openapi.model.Api;
import toy.hong.openapi.model.ApiUseApply;
import toy.hong.openapi.model.ApiUseHistory;
import toy.hong.openapi.model.ApiUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiUserController {

    @Autowired
    ApiUserService apiUserService;

    // OPEN API 사용 신청
    @PostMapping("/openapi/apply")
    public ResponseEntity<Response> applyAPIUser(Authentication authentication, ApiUseApply apiUseApply){
        apiUserService.applyAPIUser(authentication, apiUseApply);
        return new ResponseEntity<>(new Response(
                201,
                "API 이용신청이 완료되었습니다."
        ), HttpStatus.CREATED);
    }

    // OPEN API 신청내역 조회
    @GetMapping("/manage/openapi/apply")
    public ResponseEntity<Response> getAPIUseApplyList(ApiUseApply apiUseApply){
        Map<String, Object> data = new HashMap<>();
        data.put("apiUseApplyList", apiUserService.getAPIUseApplyList(apiUseApply));
        return new ResponseEntity<>(new Response(
                200,
                "신청내역 조회 성공",
                data
        ), HttpStatus.OK);
    }

    // OPEN API 신청 승인
    @PutMapping("/manage/openapi/apply")
    public ResponseEntity<Response> approveAPIUserApply(ApiUseApply apiUseApply){
        apiUserService.approveAPIUserApply(apiUseApply);
        return new ResponseEntity<>(new Response(
                200,
                "API 등록이 완료되었습니다."
        ), HttpStatus.OK);
    }

    // OPEN API 사용 이력 조회
    @GetMapping("/manage/openapi/use")
    public ResponseEntity<Response> getAPIUseHistory(ApiUseHistory apiUseHistory){
        Map<String, Object> data = new HashMap<>();
        data.put("apiUseHistoryList", apiUserService.getAPIUseHistory(apiUseHistory));
        return new ResponseEntity<>(new Response(
                200,
                "성공",
                data
        ), HttpStatus.OK);
    }

}
