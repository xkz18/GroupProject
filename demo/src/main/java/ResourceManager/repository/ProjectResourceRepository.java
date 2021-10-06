package ResourceManager.repository;

import ResourceManager.entity.Project;
import ResourceManager.entity.Resource;
import ResourceManager.entity.ProjectResources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResources, Integer> {

    public List<ProjectResources> findByProject(Project project);
    public List<ProjectResources> findByResource(Resource resource);


}
