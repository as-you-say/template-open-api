package toy.hong.openapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.hong.openapi.app.repositories.ApiRepository;
import toy.hong.openapi.app.repositories.ApiUrlRepository;
import toy.hong.openapi.app.service.validation.ApiValidationService;
import toy.hong.openapi.model.Api;
import toy.hong.openapi.model.ApiUrl;

@Service
public class ApiService extends ApiValidationService {

    @Autowired
    ApiRepository apiRepository;

    @Autowired
    ApiUrlRepository apiUrlRepository;

    public void addAPI(Api api){
        // 밸리데이션 체크
        validateAddAPI(api);

        // OPEN API 등록
        apiRepository.save(api);
        for (ApiUrl apiUrl : api.getApiUrls()) {
            apiUrlRepository.save(apiUrl);
        }
    }

    public void modifyAPI(Api api){
        // 밸리데이션 체크
        validateModifyAPI(api);

        // OPEN API 수정
        apiRepository.save(api);
        for (ApiUrl apiUrl : api.getApiUrls()) {
            apiUrlRepository.save(apiUrl);
        }
    }

    public void removeAPI(Api api){
        // 밸리데이션 체크
        validateRemoveAPI(api);

        // OPEN API 삭제
        for (ApiUrl apiUrl : api.getApiUrls()) {
            apiUrlRepository.delete(apiUrl);
        }
        apiRepository.delete(api);
    }

}
