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
    private String id;

    // 컬럼
    @Column(name = "password")
    private String password;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
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

}
