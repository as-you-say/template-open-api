package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ApiUrl {
    // 기본키
    @Id
    private String id;

    // 컬럼
    private String requestType;
    private String requestUrl;
    private Date createAt;
    private Date updateAt;

    // 조인
    @ManyToOne
    private Api api;
    @OneToMany(mappedBy = "apiUrl")
    private List<ApiUserRequestLog> apiUserRequestLogs = new ArrayList<>();
}
