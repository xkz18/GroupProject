package ResourceManager.repository;

import ResourceManager.entity.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumns, Integer> {
}
