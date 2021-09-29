package Repository;

import ResourceManager.model.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumns, Integer> {
}
