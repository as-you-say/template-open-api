package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "api_user_auth")
@Getter
@Setter
public class ApiUserAuth {
    // 기본키
    @Id
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API 사용자 권한 아이디")
    private String id;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

    @ManyToOne
    @JoinColumn(name = "api_auth_id")
    private ApiAuth apiAuth;
}
