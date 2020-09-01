package toy.hong.openapi.app.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import toy.hong.openapi.app.exception.RequestParamValidationException;
import toy.hong.openapi.model.ApiUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/database-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    UserService userService;

    ApiUser apiUser;

    @Before
    public void init() {
        apiUser = new ApiUser();
        apiUser.setUsername("hello");
        apiUser.setPassword("Hello1234!");
        apiUser.setPassword_confirm("Hello1234!");
        apiUser.setPurpose("사용목적");
    }

    @Test
    @Transactional
    public void TEST_01_signUp_OK() {
        userService.signUp(apiUser);
    }

    @Test(expected = RequestParamValidationException.class)
    @Transactional
    public void TEST_02_signUp_Username_NOT_VALID() {
        apiUser.setUsername("!@#@$!$");
        apiUser.setPassword("Hello1234!");
        apiUser.setPassword_confirm("Hello1234!");

        userService.signUp(apiUser);
    }

    @Test(expected = RequestParamValidationException.class)
    @Transactional
    public void TEST_02_signUp_Password_NOT_VALID() {
        apiUser.setUsername("hello");
        apiUser.setPassword("hello1234!");
        apiUser.setPassword_confirm("hello1234!");

        userService.signUp(apiUser);
    }

    @Test(expected = RequestParamValidationException.class)
    @Transactional
    public void TEST_03_signUp_Password_Confirm_NOT_VALID() {
        apiUser.setUsername("hello");
        apiUser.setPassword("Hello1234!");
        apiUser.setPassword_confirm("Hello1234!!!!");

        userService.signUp(apiUser);
    }

    @Test(expected = RequestParamValidationException.class)
    @Transactional
    public void TEST_04_signUp_Purpose_NOT_VALID() {
        apiUser.setUsername("hello");
        apiUser.setPassword("Hello1234!");
        apiUser.setPassword_confirm("Hello1234!");
        apiUser.setPurpose("");

        userService.signUp(apiUser);
    }

}
