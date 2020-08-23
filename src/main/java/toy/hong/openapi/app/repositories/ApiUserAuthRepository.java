package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUser;
import toy.hong.openapi.model.ApiUserAuth;

import java.util.List;

public interface ApiUserAuthRepository extends CrudRepository<ApiUserAuth, Long> {
    List<ApiUserAuth> findAllByApiUser(ApiUser apiUser);
}
