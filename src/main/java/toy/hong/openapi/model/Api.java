package toy.hong.openapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import toy.hong.openapi.model.common.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api")
@Getter
@Setter
public class Api extends Page {

    // 기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼
    @Column(name = "domain", nullable = false, length = 63)
    private String domain;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "create_at", nullable = false)
    private Date createAt;

    @Column(name = "update_at", nullable = false)
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "api")
    private List<ApiUrl> apiUrls;

    @OneToMany(mappedBy = "api")
    private List<ApiUseHistory> apiUseHistories;

}
