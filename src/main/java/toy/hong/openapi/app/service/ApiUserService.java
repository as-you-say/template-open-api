package toy.hong.openapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.hong.openapi.app.exception.DataNotFoundException;
import toy.hong.openapi.app.repositories.ApiRepository;
import toy.hong.openapi.app.repositories.ApiUseApplyRepository;
import toy.hong.openapi.app.repositories.ApiUseHistoryRepository;
import toy.hong.openapi.app.service.validation.ApiUserValidationService;
import toy.hong.openapi.model.ApiUseApply;
import toy.hong.openapi.model.ApiUseHistory;
import toy.hong.openapi.model.ApiUser;

import java.util.List;

@Service
public class ApiUserService extends ApiUserValidationService {

    @Autowired
    ApiUseApplyRepository apiUseApplyRepository;

    @Autowired
    ApiUseHistoryRepository apiUseHistoryRepository;

    @Autowired
    ApiRepository apiRepository;

    @Transactional
    public void applyAPIUser(Authentication authentication, ApiUseApply apiUseApply){
        // 밸리데이션 체크
        validateApplyAPIUser(apiUseApply);
        boolean isNotFoundAPI = apiRepository.findOne(apiUseApply.getApi().getId()) == null;
        if(isNotFoundAPI){
            throw new DataNotFoundException("선택한 API를 찾을 수 없습니다.");
        }

        // API 사용신청
        ApiUser apiUser = (ApiUser) authentication.getPrincipal();
        apiUseApply.setApiUser(apiUser);
        apiUseApplyRepository.save(apiUseApply);
    }

    @Transactional
    public List<ApiUseApply> getAPIUseApplyList(ApiUseApply apiUseApply){
        // 밸리데이션 체크
        validateGetAPIUseApplyList(apiUseApply);

        // OPEN API 신청내역 조회
        Pageable pageable = new PageRequest(apiUseApply.getPageNo()-1, apiUseApply.getPageSize());
        Page<ApiUseApply> page = apiUseApplyRepository.findAll(pageable);
        return page.getContent();
    }

    @Transactional
    public void approveAPIUserApply(ApiUseApply apiUseApply){
        // 밸리데이션 체크
        validateApproveAPIUserApply(apiUseApply);
        boolean isNotFoundApply = apiUseApplyRepository.findOne(apiUseApply.getId()) == null;
        if (isNotFoundApply) {
            throw new DataNotFoundException("선택한 API 신청내역을 찾을 수 없습니다.");
        }

        // API 사용신청 승인
        apiUseApply.setStatus(1);
        apiUseApplyRepository.save(apiUseApply);
    }

    @Transactional
    public List<ApiUseHistory> getAPIUseHistory(ApiUseHistory apiUseHistory){
        // 밸리데이션 체크
        validateGetAPIUseHistory(apiUseHistory);

        // OPEN API 신청내역 조회
        Pageable pageable = new PageRequest(apiUseHistory.getPageNo()-1, apiUseHistory.getPageSize());
        Page<ApiUseHistory> page = apiUseHistoryRepository.findAll(pageable);
        return page.getContent();
    }

}
