package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "api_auth")
@Getter
@Setter
public class ApiAuth {
    // 기본키
    @Id
    private String id;

    // 컬럼
    @Column(name = "name")
    private String name;

    // 조인
    @OneToMany(mappedBy = "apiAuth")
    private List<ApiUserAuth> apiUserAuths = new ArrayList<>();
}
