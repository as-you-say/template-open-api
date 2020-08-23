package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUser;

public interface ApiUserRepository extends CrudRepository<ApiUser, Long> {
    ApiUser findApiUserByUsername(String username);
}
