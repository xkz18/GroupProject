package com.example.demo.Repository;

import com.example.demo.ResourceManager.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer > {
}