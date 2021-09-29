package ResourceManager.repository;

import ResourceManager.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResourceRepository extends JpaRepository<Resource,Integer > {
}
