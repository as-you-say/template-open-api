package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api_url")
@Getter
@Setter
public class ApiUrl {

    // 기본키
    @Id
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API URL 아이디")
    private String id;

    // 컬럼
    @Column(name = "request_type", nullable = false, length = 5, columnDefinition = "API URL 요청 타입")
    private String requestType;

    @Column(name = "request_url", nullable = false, length = 64, columnDefinition = "API URL 주소")
    private String requestUrl;

    @Column(name = "create_at", nullable = false, columnDefinition = "등록일")
    private Date createAt;

    @Column(name = "update_at", nullable = false, columnDefinition = "수정일")
    private Date updateAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;

    @OneToMany(mappedBy = "apiUrl")
    private List<ApiUserRequestLog> apiUserRequestLogs = new ArrayList<>();

}
