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
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API 요청 이력 아이디")
    private String id;

    // 컬럼
    @Column(name = "ip", nullable = false, length = 15, columnDefinition = "API 요청 아이피")
    private String ip;

    @Lob
    @Column(name = "request", nullable = false, columnDefinition = "API 요청 이력")
    private String request;

    @Lob
    @Column(name = "response", nullable = false, columnDefinition = "API 응답 이력")
    private String response;

    @Column(name = "message", nullable = false, length = 50, columnDefinition = "사용 이력 내용")
    private String errorMessage;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

    @ManyToOne
    @JoinColumn(name = "api_url_id")
    private ApiUrl apiUrl;
}
