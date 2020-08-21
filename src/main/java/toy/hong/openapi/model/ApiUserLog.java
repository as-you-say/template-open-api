package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "api_user_log")
@Getter
@Setter
public class ApiUserLog {
    // 기본키
    @Id
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "사용 이력 아이디")
    private String id;

    // 컬럼
    @Column(name = "ip", nullable = false, length = 15, columnDefinition = "접속한 아이피")
    private String ip;

    @Column(name = "message", nullable = false, length = 50, columnDefinition = "사용 이력 내용")
    private String message;

    @Column(name = "create_at", nullable = false, columnDefinition = "등록일")
    private Date createAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;
}
