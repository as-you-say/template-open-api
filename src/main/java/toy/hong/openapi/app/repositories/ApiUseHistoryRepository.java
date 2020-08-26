package toy.hong.openapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import toy.hong.openapi.model.ApiUseHistory;

public interface ApiUseHistoryRepository extends PagingAndSortingRepository<ApiUseHistory, Long> {
}
