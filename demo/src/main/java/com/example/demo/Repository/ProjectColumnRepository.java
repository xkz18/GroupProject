package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.Project;
import com.example.demo.ResourceManager.model.ProjectColumns;
import com.example.demo.ResourceManager.model.ProjectResources;
import com.example.demo.ResourceManager.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectColumnRepository extends JpaRepository<ProjectColumns, Integer> {
    public List<ProjectColumns> findByProject(Project project);
}
