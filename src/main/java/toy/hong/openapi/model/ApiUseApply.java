package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "api_use_apply")
@Getter
@Setter
public class ApiUseApply {
    // 기본키
    @Id
    private String id;

    // 컬럼
    @Column(name = "project_name")
    private String projectName;
    
    @Column(name = "ip")
    private String ip;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "create_at")
    private Date createAt;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;
    
    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;
    
    @OneToMany(mappedBy = "apiUseApply")
    private List<ApiUseHistory> apiUseHistories = new ArrayList<>();
}
