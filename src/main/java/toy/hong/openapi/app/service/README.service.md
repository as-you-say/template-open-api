# Regex Example
```text
Password Regex    
    ^                 # start-of-string    
    (?=.*[0-9])       # a digit must occur at least once    
    (?=.*[a-z])       # a lower case letter must occur at least once    
    (?=.*[A-Z])       # an upper case letter must occur at least once   
    (?=.*[@#$%^&+=])  # a special character must occur at least once    
    (?=\S+$)          # no whitespace allowed in the entire string  
    .{8,}             # anything, at least eight places though  
    $                 # end-of-string
```   
``` java
private final String REGEX_USER_ID = "^[a-zA-Z0-9_]*$";
private final String REGEX_USER_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!@#$%^&+=])(?=\\S+$).{8,}$";
private final String REGEX_USER_PURPOSE = "^[a-zA-Z가-힣]*$";
private final String REGEX_USER_NAME = "^[a-zA-Z가-힣]*$";
private final String REGEX_USER_DEPART = "^[a-zA-Z가-힣]*$";
private final String REGEX_USER_PHONE = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
private final String REGEX_USER_EMAIL = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
private final String REGEX_USER_CLOUD_TYPE = "^[1|2]{1}$";
private final String REGEX_USER_STORAGE_USE_YN = "^[Y|N]{1}$";
```

