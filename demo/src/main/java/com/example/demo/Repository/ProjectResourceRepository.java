package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.ProjectResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResources, Integer> {
}
