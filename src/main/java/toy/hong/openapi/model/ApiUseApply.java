package toy.hong.openapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ApiUseApply {
    @Id
    private String id;

    private String projectName;
    private String ip;
    private int status;
    private Date createAt;

    @ManyToOne
    private ApiUser apiUser;
    @ManyToOne
    private Api api;
    @OneToMany(mappedBy = "apiUseApply")
    private List<ApiUseHistory> apiUseHistories = new ArrayList<>();
}
