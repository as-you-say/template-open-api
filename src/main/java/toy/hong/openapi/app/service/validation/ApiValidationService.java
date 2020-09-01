package toy.hong.openapi.app.service.validation;

import toy.hong.openapi.model.Api;

public class ApiValidationService extends ValidationService {

    private final String REGEX_ID = "^[a-zA-Z0-9_]*$";
    private final String REGEX_NAME = "^[a-zA-Z가-힣]*$";
    private final String REGEX_DOMAIN = "^[a-zA-Z가-힣]*$";
    private final String REGEX_REQUEST_URL = "^[a-zA-Z가-힣]*$";
    private final String REGEX_REQUEST_TYPE = "^[a-zA-Z가-힣]*$";

    public void validateAddAPI(Api api){
        validate("Name", api.getName(), REGEX_NAME);
        validate("Domain", api.getDomain(), REGEX_DOMAIN);
        api.getApiUrls().forEach(apiUrl -> {
            validate("Request Url", apiUrl.getRequestUrl(), REGEX_REQUEST_URL);
            validate("Request Type", apiUrl.getRequestType(), REGEX_REQUEST_TYPE);
        });
    }

    public void validateModifyAPI(Api api){
        validate("Id", api.getId(), REGEX_ID);
        validate("Name", api.getName(), REGEX_NAME);
        validate("Domain", api.getDomain(), REGEX_DOMAIN);
        api.getApiUrls().forEach(apiUrl -> {
            validate("Request Url", apiUrl.getRequestUrl(), REGEX_REQUEST_URL);
            validate("Request Type", apiUrl.getRequestType(), REGEX_REQUEST_TYPE);
        });
    }

    public void validateRemoveAPI(Api api){
        validate("Id", api.getId(), REGEX_ID);
    }

}
