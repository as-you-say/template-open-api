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
    private String id;

    // 컬럼
    @Column(name = "ip")
    private String ip;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

    @Column(name = "error_message")
    private String errorMessage;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

    @ManyToOne
    @JoinColumn(name = "api_url_id")
    private ApiUrl apiUrl;
}
