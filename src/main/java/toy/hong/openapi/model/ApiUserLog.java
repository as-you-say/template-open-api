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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // 컬럼
    @Column(name = "ip", nullable = false, length = 15)
    private String ip;

    @Column(name = "message", nullable = false, length = 50)
    private String message;

    @Column(name = "create_at", nullable = false)
    private Date createAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;
}
