package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUserLog;

public interface ApiUserLogRepository extends CrudRepository<ApiUserLog, Long> {

}
