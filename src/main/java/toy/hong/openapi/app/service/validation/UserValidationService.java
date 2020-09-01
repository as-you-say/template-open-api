package toy.hong.openapi.app.service.validation;

import toy.hong.openapi.app.exception.RequestParamValidationException;
import toy.hong.openapi.model.ApiUser;

public class UserValidationService extends ValidationService {

    private final String REGEX_USER_ID = "^[a-zA-Z0-9_]*$";
    private final String REGEX_USER_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!@#$%^&+=])(?=\\S+$).{8,}$";
    private final String REGEX_USER_PURPOSE = "^[a-zA-Z가-힣]*$";

    public void validateSignUp(ApiUser apiUser){
        validate("Username", apiUser.getUsername(), REGEX_USER_ID);
        validate("Password", apiUser.getPassword(), REGEX_USER_PASSWORD);
        boolean isValidatePasswordConfirm = apiUser.getPassword().equals(apiUser.getPassword_confirm());
        if (!isValidatePasswordConfirm) {
            throw new RequestParamValidationException("비밀번호와 비밀번호 확인 입력값이 다릅니다.");
        }
        validate("Purpose", apiUser.getPurpose(), REGEX_USER_PURPOSE);
    }

}
