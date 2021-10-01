package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumns, Integer> {
}
