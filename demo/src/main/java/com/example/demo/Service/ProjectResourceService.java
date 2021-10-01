package com.example.demo.Service;

import com.example.demo.ResourceManager.model.*;

import java.util.List;

public interface ProjectResourceService {
    public ProjectResources addProjectResource(ProjectResources projectResource);
    public void deleteProjectResource(Integer record_id);
    public ProjectResources getProjectResource(Integer record_id);
    public List<ProjectResources> getAllProjectResources();
}
