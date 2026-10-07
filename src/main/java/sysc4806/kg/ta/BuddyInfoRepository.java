package sysc4806.kg.ta;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(int id);
}
