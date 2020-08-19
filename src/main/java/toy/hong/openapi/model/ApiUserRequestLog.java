package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ApiUserRequestLog {
    @Id
    private String id;

    private String ip;
    private String request;
    private String response;
    private String errorMessage;

    @ManyToOne
    private ApiUser apiUser;

    @ManyToOne
    private ApiUrl apiUrl;
}
