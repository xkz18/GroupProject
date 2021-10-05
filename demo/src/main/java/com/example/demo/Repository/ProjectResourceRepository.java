package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.Project;
import com.example.demo.ResourceManager.model.ProjectColumns;
import com.example.demo.ResourceManager.model.ProjectResources;
import com.example.demo.ResourceManager.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectResourceRepository extends JpaRepository<ProjectResources, Integer> {
    public List<ProjectResources> findByProject(Project project);
    public List<ProjectResources> findByResource(Resource resource);
}
