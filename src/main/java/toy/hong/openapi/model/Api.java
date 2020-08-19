package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Api {

    // 기본키
    @Id
    private String id;

    // 컬럼
    private String domain;
    private String name;
    private Date createAt;
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "api")
    private List<ApiUrl> apiUrls = new ArrayList<>();
    @OneToMany(mappedBy = "api")
    private List<ApiUseHistory> apiUseHistories = new ArrayList<>();

}
