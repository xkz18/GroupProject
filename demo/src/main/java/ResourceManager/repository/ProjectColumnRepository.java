package ResourceManager.repository;

import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface ProjectColumnRepository extends JpaRepository<ProjectColumns, Integer> {

    public List<ProjectColumns> findByProject(Project project);

}
