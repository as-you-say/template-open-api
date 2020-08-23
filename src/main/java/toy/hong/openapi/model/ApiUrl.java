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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // 컬럼
    @Column(name = "request_type", nullable = false, length = 5)
    private String requestType;

    @Column(name = "request_url", nullable = false, length = 64)
    private String requestUrl;

    @Column(name = "create_at", nullable = false)
    private Date createAt;

    @Column(name = "update_at", nullable = false)
    private Date updateAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;

    @OneToMany(mappedBy = "apiUrl")
    private List<ApiUserRequestLog> apiUserRequestLogs;

}
