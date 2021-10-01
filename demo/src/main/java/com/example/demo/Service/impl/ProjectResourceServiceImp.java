package com.example.demo.Service.impl;

import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Override
    public ProjectResources addProjectResource(ProjectResources projectResource){
        return repository.save(projectResource);
    }

    @Override
    public void deleteProjectResource(Integer record_id){
        repository.deleteById(record_id);
    }

    @Override
    public ProjectResources getProjectResource(Integer record_id){
        return repository.getById(record_id);
    }

    @Override
    public List<ProjectResources> getAllProjectResources(){
        return repository.findAll();
    }
}
