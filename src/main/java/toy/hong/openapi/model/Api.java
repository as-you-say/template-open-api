package toy.hong.openapi.model;

import lombok.Getter;
import lombok.NonNull;
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
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API 아이디")
    private String id;

    // 컬럼
    @Column(name = "domain", nullable = false, length = 63, columnDefinition = "API 도메인")
    private String domain;

    @Column(name = "name", nullable = false, length = 15, columnDefinition = "API 이름")
    private String name;

    @Column(name = "create_at", nullable = false, columnDefinition = "등록일")
    private Date createAt;

    @Column(name = "update_at", nullable = false, columnDefinition = "수정일")
    private Date updateAt;

    // 조인
    @OneToMany(mappedBy = "api")
    private List<ApiUrl> apiUrls = new ArrayList<>();

    @OneToMany(mappedBy = "api")
    private List<ApiUseHistory> apiUseHistories = new ArrayList<>();

}
