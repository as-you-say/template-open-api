package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ApiUserAuth {
    @Id
    private String id;

    @ManyToOne
    private ApiUser apiUser;

    @ManyToOne
    private ApiAuth apiAuth;
}
