package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.Api;

public interface ApiRepository extends CrudRepository<Api, String> {
}
