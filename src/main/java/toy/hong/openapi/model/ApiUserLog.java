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
    private String id;

    // 컬럼
    @Column(name = "ip")
    private String ip;

    @Column(name = "message")
    private String message;

    @Column(name = "create_at")
    private Date createAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;
}
