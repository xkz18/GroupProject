package ResourceManager.repository;





import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.ProjectResources;
import ResourceManager.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectResourceRepository extends JpaRepository<ProjectResources, Integer> {
    public List<ProjectResources> findByProject(Project project);
    public List<ProjectResources> findByResource(Resource resource);
}
