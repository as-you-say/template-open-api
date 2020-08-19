package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class ApiUserLog {
    @Id
    private String id;

    private String ip;
    private String message;
    private Date createAt;

    @ManyToOne
    private ApiUser apiUser;
}
