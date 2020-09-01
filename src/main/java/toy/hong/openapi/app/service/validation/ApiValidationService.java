package toy.hong.openapi.app.service.validation;

import toy.hong.openapi.model.Api;

public class ApiValidationService extends ValidationService {

    /*
    * REGEX_NAME : 한글/영문, 1글자 이상
    * REGEX_DOMAIN : 영문/숫자, 7글자 이상
    * REGEX_REQUEST_URL : 영문/숫자/특수문자(/), 5글자 이상
    * REGEX_REQUEST_TYPE : GET,POST,PUT,PATCH,DELETE 중에서 1개 선택
    * */
    private final String REGEX_NAME = "^[a-zA-Z가-힣]{1,}$";
    private final String REGEX_DOMAIN = "^[a-zA-Z0-9]{7,}$";
    private final String REGEX_REQUEST_URL = "^[\\/a-zA-Z0-9]{5,}$";
    private final String REGEX_REQUEST_TYPE = "^(GET|POST|PUT|PATCH|DELETE)$";

    public void validateAddAPI(Api api){
        validate("Name", api.getName(), REGEX_NAME);
        validate("Domain", api.getDomain(), REGEX_DOMAIN);
        api.getApiUrls().forEach(apiUrl -> {
            validate("Request Url", apiUrl.getRequestUrl(), REGEX_REQUEST_URL);
            validate("Request Type", apiUrl.getRequestType(), REGEX_REQUEST_TYPE);
        });
    }

    public void validateModifyAPI(Api api){
        validate("Id", api.getId(), api.getId()>0);
        validate("Name", api.getName(), REGEX_NAME);
        validate("Domain", api.getDomain(), REGEX_DOMAIN);
        api.getApiUrls().forEach(apiUrl -> {
            validate("Request Url", apiUrl.getRequestUrl(), REGEX_REQUEST_URL);
            validate("Request Type", apiUrl.getRequestType(), REGEX_REQUEST_TYPE);
        });
    }

    public void validateRemoveAPI(Api api){
        validate("Id", api.getId(), api.getId()>0);
    }

}
