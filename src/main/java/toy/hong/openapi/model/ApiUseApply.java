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
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API 사용 신청 아이디")
    private String id;

    // 컬럼
    @Column(name = "project_name", nullable = false, length = 15, columnDefinition = "API 사용 신청 프로젝트 이름")
    private String projectName;
    
    @Column(name = "ip", nullable = false, length = 64, columnDefinition = "API 사용 신청 아이피")
    private String ip;
    
    @Column(name = "status", nullable = false, length = 5, columnDefinition = "API 사용 신청 상태")
    private Integer status;
    
    @Column(name = "create_at", nullable = false, columnDefinition = "등록일")
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
