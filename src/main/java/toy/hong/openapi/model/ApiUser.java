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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // 컬럼
    @Column(name = "username", nullable = false, length = 60, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "purpose", nullable = false, length = 20)
    private String purpose;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserRequestLog> apiUserRequestLogs;

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserLog> apiUserLogs;

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserAuth> apiUserAuths;

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUseApply> apiUseApplies;

    public String[] getSecurityAuthArray(){
        int authSize = apiUserAuths.size();
        String[] authArray = new String[authSize];

        for(int i=0; i<authSize; i++){
            authArray[i] = apiUserAuths.get(i).getApiAuth().getName();
        }

        return authArray;
    }

}
