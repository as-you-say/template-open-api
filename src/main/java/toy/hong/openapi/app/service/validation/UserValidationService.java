package toy.hong.openapi.app.service.validation;

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

    private final String REGEX_USER_NAME = "^[a-zA-Z가-힣]*$";
    private final String REGEX_USER_DEPART = "^[a-zA-Z가-힣]*$";
    private final String REGEX_USER_PHONE = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
    private final String REGEX_USER_EMAIL = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    private final String REGEX_USER_CLOUD_TYPE = "^[1|2]{1}$";
    private final String REGEX_USER_STORAGE_USE_YN = "^[Y|N]{1}$";

    private void validate(String name, Object param){
        boolean isEmpty = false;
        if(param instanceof String) {
            isEmpty = "".equals((String)param);
        }
        if (param == null || isEmpty) {
            throw new RuntimeException(name + " - 값이 NULL 입니다.");
        }
    }

    private void validate(String name, Object param, String regex){
        validate(name, param);
        String paramString = "" + param;
        if(!Pattern.matches(regex, paramString)){
            throw new RuntimeException(name + " - 값이 형식에 맞지 않습니다." + param);
        }
    }

    public void validateSignUp(ApiUser apiUser){
        validate("Username", apiUser.getUsername(), REGEX_USER_ID);
        validate("Password", apiUser.getPassword(), REGEX_USER_PASSWORD);
        validate("Purpose", apiUser.getPurpose(), REGEX_USER_PURPOSE);
    }

    

}
