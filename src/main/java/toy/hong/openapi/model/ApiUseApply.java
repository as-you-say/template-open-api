package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;
import toy.hong.openapi.model.common.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api_use_apply")
@Getter
@Setter
public class ApiUseApply extends Page {
    // 기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼
    @Column(name = "project_name", nullable = false, length = 15)
    private String projectName;
    
    @Column(name = "ip", nullable = false, length = 64)
    private String ip;
    
    @Column(name = "status", nullable = false, length = 5)
    private Integer status;
    
    @Column(name = "create_at", nullable = false)
    private Date createAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;
    
    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;
    
    @OneToMany(mappedBy = "apiUseApply")
    private List<ApiUseHistory> apiUseHistories;

}
