package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;
import toy.hong.openapi.model.common.Page;

import javax.persistence.*;

@Entity
@Table(name = "api_user_auth")
@Getter
@Setter
public class ApiUserAuth extends Page {
    // 기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

    @ManyToOne
    @JoinColumn(name = "api_auth_id")
    private ApiAuth apiAuth;
}
