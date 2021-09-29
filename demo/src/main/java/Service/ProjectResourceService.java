package Service;

import ResourceManager.model.ProjectColumns;
import ResourceManager.model.ProjectResources;

import java.util.List;

public interface ProjectResourceService {
    public ProjectResources addProjectResource(ProjectResources projectResource);
    public void deleteProjectResource(Integer record_id);
    public ProjectResources getProjectResource(Integer record_id);
    public List<ProjectResources> getAllProjectResources();
}
