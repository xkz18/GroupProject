package ResourceManager.Service;

import ResourceManager.entity.*;

import java.util.List;

public interface ProjectResourceService {
    public ProjectResources addProjectResource(ProjectResources projectResource);
    public boolean deleteProjectResource(Integer record_id);
    public ProjectResources getProjectResource(Integer record_id);
    public List<ProjectResources> getAllProjectResources();
}
