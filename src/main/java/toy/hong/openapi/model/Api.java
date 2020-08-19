package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api")
@Getter
@Setter
public class Api {
    // 기본키
    @Id
    private String id;

    // 컬럼
    @Column(name = "domain")
    private String domain;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "api")
    private List<ApiUrl> apiUrls = new ArrayList<>();

    @OneToMany(mappedBy = "api")
    private List<ApiUseHistory> apiUseHistories = new ArrayList<>();
}
