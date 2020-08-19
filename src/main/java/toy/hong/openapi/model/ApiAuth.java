package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ApiAuth {

    // 기본키
    @Id
    private String id;

    // 컬럼
    private String name;

    // 조인
    @OneToMany(mappedBy = "apiAuth")
    private List<ApiUserAuth> apiUserAuths = new ArrayList<>();
}
