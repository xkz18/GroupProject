package com.example.demo.Service;

import com.example.demo.ResourceManager.model.*;

import java.util.List;

public interface ProjectColumnService {
    public ProjectColumns addColumnByProject(Project project, String column_name,String type, String text);
    public ProjectColumns deleteColumn(Integer column_id);
    public ProjectColumns getColumnById(Integer column_id);
    public List<ProjectColumns> getAllColumns();
    public ProjectColumns save(ProjectColumns projectColumn);
    public List<ProjectColumns> findByProject(Project project);
}
