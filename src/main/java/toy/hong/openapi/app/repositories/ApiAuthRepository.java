package toy.hong.openapi.app.repositories;


import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiAuth;

public interface ApiAuthRepository extends CrudRepository<ApiAuth, String> {
}
