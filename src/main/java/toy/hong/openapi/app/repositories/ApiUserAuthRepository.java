package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUserAuth;

public interface ApiUserAuthRepository extends CrudRepository<ApiUserAuth, String> {

}
