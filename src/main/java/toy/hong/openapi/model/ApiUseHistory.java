package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ApiUseHistory {
    @Id
    private String id;

    private int callCount;

    @ManyToOne
    private ApiUseApply apiUseApply;
    @ManyToOne
    private Api api;
}
