package ResourceManager.repository;

import ResourceManager.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResourceRepository extends JpaRepository<Resource,Integer > {
}
