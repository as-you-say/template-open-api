package toy.hong.openapi.app.service.validation;

import toy.hong.openapi.app.exception.RequestParamValidationException;

import java.util.regex.Pattern;

public abstract class ValidationService {

    protected void validate(String name, Object param){
        boolean isEmpty = false;
        if(param instanceof String) {
            isEmpty = "".equals((String)param);
        }
        if (param == null || isEmpty) {
            throw new RequestParamValidationException(name + " - 값이 NULL 입니다.");
        }
    }

    protected void validate(String name, Object param, String regex){
        validate(name, param);
        String paramString = "" + param;
        if(!Pattern.matches(regex, paramString)){
            throw new RequestParamValidationException(name + " - 값이 형식에 맞지 않습니다." + param);
        }
    }

    protected void validate(String name, Object param, boolean isNotValid){
        validate(name, param);
        if(isNotValid){
            throw new RequestParamValidationException(name + " - 값이 형식에 맞지 않습니다." + param);
        }
    }

}
