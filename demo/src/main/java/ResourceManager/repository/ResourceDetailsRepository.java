package ResourceManager.repository;
import ResourceManager.entity.Resource;
import ResourceManager.entity.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Integer> {
}

