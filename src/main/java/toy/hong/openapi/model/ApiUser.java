package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api_user")
@Getter
@Setter
public class ApiUser {

    //기본키
    @Id
    @Column(name = "id", nullable = false, length = 50, columnDefinition = "API 사용자 아이디")
    private String id;

    // 컬럼
    @Column(name = "password", nullable = false, length = 60, columnDefinition = "API 사용자 비밀번호")
    private String password;

    @Column(name = "purpose", nullable = false, length = 20, columnDefinition = "API 사용목적")
    private String purpose;

    @Column(name = "create_at", nullable = false, columnDefinition = "등록일")
    private Date createAt;

    @Column(name = "update_at", nullable = false, columnDefinition = "수정일")
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserRequestLog> apiUserRequestLogs = new ArrayList<>();

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserLog> apiUserLogs = new ArrayList<>();

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserAuth> apiUserAuths = new ArrayList<>();

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUseApply> apiUseApplies = new ArrayList<>();

    public String[] getSecurityAuthArray(){
        int authSize = apiUserAuths.size();
        String[] authArray = new String[authSize];

        for(int i=0; i<authSize; i++){
            authArray[i] = apiUserAuths.get(i).getApiAuth().getName();
        }

        return authArray;
    }

}
