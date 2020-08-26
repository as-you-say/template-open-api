package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;
import toy.hong.openapi.model.common.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "api_auth")
@Getter
@Setter
public class ApiAuth extends Page {

    // 기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    // 조인
    @OneToMany(mappedBy = "apiAuth")
    private List<ApiUserAuth> apiUserAuths;

}
