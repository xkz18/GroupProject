package com.example.demo.Service;

import com.example.demo.ResourceManager.model.*;

import java.util.List;

public interface ProjectColumnService {
    public ProjectColumns addColumn(ProjectColumns projectColumn);
    public Boolean deleteColumn(Integer column_id);
    public ProjectColumns getColumn(Integer column_id);
    public List<ProjectColumns> getAllColumns();
}
