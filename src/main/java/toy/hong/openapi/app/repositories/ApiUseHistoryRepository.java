package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import toy.hong.openapi.model.ApiUseHistory;

public interface ApiUseHistoryRepository extends CrudRepository<ApiUseHistory, Long> {
}
