package com.example.demo.Service;

import com.example.demo.ResourceManager.model.*;

import java.util.List;

public interface ProjectColumnService {
    public ProjectColumns addColumnByProject(Integer project_id, String column_name,String type);
    public Boolean deleteColumn(Integer column_id);
    public ProjectColumns getColumnById(Integer column_id);
    public List<ProjectColumns> getAllColumns();
    public ProjectColumns save(ProjectColumns projectColumn);
    public List<ProjectColumns> findByProject(Project project);
}
