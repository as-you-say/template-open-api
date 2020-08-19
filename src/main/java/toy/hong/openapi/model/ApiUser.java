package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ApiUser {
    @Id
    private String id;

    private String password;
    private String purpose;
    private Date createAt;
    private Date updateAt;

    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserRequestLog> apiUserRequestLogs = new ArrayList<>();
    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserLog> apiUserLogs = new ArrayList<>();
    @OneToMany(mappedBy = "apiUser")
    private List<ApiUserAuth> apiUserAuths = new ArrayList<>();
    @OneToMany(mappedBy = "apiUser")
    private List<ApiUseApply> apiUseApplies = new ArrayList<>();
}
