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
    @Column(name = "id", nullable = false, length = 32, columnDefinition = "API 사용 내역 아이디")
    private String id;

    // 컬럼
    @Column(name = "call_count", nullable = false, columnDefinition = "API 사용 횟수")
    private Integer callCount;

    // 조인
    @ManyToOne
    @JoinColumn(name = "api_use_apply_id")
    private ApiUseApply apiUseApply;

    @ManyToOne
    @JoinColumn(name = "api_id")
    private Api api;

}
