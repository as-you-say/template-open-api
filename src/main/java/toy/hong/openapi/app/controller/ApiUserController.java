package toy.hong.openapi.app.controller;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUserController {

    // OPEN API 사용 신청
    @PostMapping("/openapi/apply")
    public void applyAPIUser(){
    }

    // OPEN API 신청 현황 조회
    @GetMapping("/manage/openapi/apply")
    public void getAPIUserApplyList(){
    }

    // OPEN API 신청 승인
    @PutMapping("/manage/openapi/apply")
    public void approveAPIUserApply(){
    }

    // OPEN API 사용 이력 조회
    @GetMapping("/manage/openapi/use")
    public void getAPIUserUseHistory(){
    }

}
