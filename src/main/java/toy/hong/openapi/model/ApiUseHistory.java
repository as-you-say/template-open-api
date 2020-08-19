package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "api_use_history")
@Getter
@Setter
public class ApiUseHistory {
    // 기본키
    @Id
    private String id;

    // 컬럼
    @Column(name = "call_count")
    private Integer callCount;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_use_apply_id")
    private ApiUseApply apiUseApply;

    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;
}
