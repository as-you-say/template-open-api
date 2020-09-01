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
import toy.hong.openapi.model.Api;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/database-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiUserServiceTest {

    @Autowired
    ApiUserService apiUserService;

    Api api;

    @Before
    public void init() {
        api = new Api();
        api.setName("API 이름");
        api.setDomain("API 도메인");
    }

    @Test
    @Transactional
    public void TEST_01_applyAPIUser() {}

    @Test
    @Transactional
    public void TEST_02_getAPIUseApplyList() {}

    @Test
    @Transactional
    public void TEST_03_approveAPIUserApply() {}

    @Test
    @Transactional
    public void TEST_04_getAPIUseHistory() {}

}