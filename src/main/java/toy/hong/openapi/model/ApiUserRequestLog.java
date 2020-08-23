package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "api_user_request_log")
@Getter
@Setter
public class ApiUserRequestLog {
    // 기본키
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // 컬럼
    @Column(name = "ip", nullable = false, length = 15)
    private String ip;

    @Lob
    @Column(name = "request", nullable = false)
    private String request;

    @Lob
    @Column(name = "response", nullable = false)
    private String response;

    @Column(name = "message", nullable = false, length = 50)
    private String errorMessage;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

    @ManyToOne
    @JoinColumn(name = "api_url_id")
    private ApiUrl apiUrl;
}
