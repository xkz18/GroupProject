package ResourceManager.Service;

import ResourceManager.entity.*;

import java.util.List;

public interface ProjectResourceService {
    public ProjectResources addProjectResource(Integer project_id, Integer resource_id);
    public boolean deleteProjectResource(Integer record_id);
    public ProjectResources getProjectResourceById(Integer record_id);
    public List<ProjectResources> getAllProjectResources();
    public ProjectResources save(ProjectResources projectResource);
    public List<ProjectResources> findByProject(Project project);
    public List<ProjectResources> findByResource(Resource resource);
}
