package toy.hong.openapi.app.service.validation;

import toy.hong.openapi.app.exception.RequestParamValidationException;
import toy.hong.openapi.model.ApiUser;

import java.util.regex.Pattern;

public class UserValidationService {
    /*  비밀번호 정책
        ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
    */
    private final String REGEX_USER_ID = "^[a-zA-Z0-9_]*$";
    private final String REGEX_USER_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!@#$%^&+=])(?=\\S+$).{8,}$";
    private final String REGEX_USER_PURPOSE = "^[a-zA-Z가-힣]*$";

    private void validate(String name, Object param){
        boolean isEmpty = false;
        if(param instanceof String) {
            isEmpty = "".equals((String)param);
        }
        if (param == null || isEmpty) {
            throw new RequestParamValidationException(name + " - 값이 NULL 입니다.");
        }
    }

    private void validate(String name, Object param, String regex){
        validate(name, param);
        String paramString = "" + param;
        if(!Pattern.matches(regex, paramString)){
            throw new RequestParamValidationException(name + " - 값이 형식에 맞지 않습니다." + param);
        }
    }

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
