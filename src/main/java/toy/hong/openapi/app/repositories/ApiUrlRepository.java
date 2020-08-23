package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUrl;

public interface ApiUrlRepository extends CrudRepository<ApiUrl, Long> {
}
