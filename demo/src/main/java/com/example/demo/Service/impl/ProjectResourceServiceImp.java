package com.example.demo.Service.impl;

import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Autowired
    ProjectRepository project_repo;

    @Autowired
    ResourceRepository resource_repo;

    @Override
    public ProjectResources addProjectResource(Project project, Resource resource){
        //Project project=project_repo.findById(project_id).orElse(null);
        if(project ==null){
            System.out.println("Project ID is not valid");
            return null;
        }
        //Resource resource=resource_repo.findById(resource_id).orElse(null);
        if(resource==null){
            System.out.println("Resource ID is not valid");
            return null;
        }
        ProjectResources projectResources=new ProjectResources();
        projectResources.setProject(project);
        projectResources.setResource(resource);
        projectResources.setTime_created(new Date(System.currentTimeMillis()));

        ProjectResources result=repository.save(projectResources);
        return result;
    }

    @Override
    public ProjectResources deleteProjectResource(Integer record_id){
        Optional<ProjectResources> target=repository.findById(record_id);
        if (target.isPresent()) {
            repository.deleteById(record_id);
            return target.get();
        }
        else {
            return null;
        }
    }

    @Override
    public ProjectResources getProjectResourceById(Integer record_id){
        Optional<ProjectResources> target= repository.findById(record_id);
        if(target.isPresent()) {
            return target.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<ProjectResources> getAllProjectResources(){
        return repository.findAll();
    }

    @Override
    public ProjectResources save(ProjectResources projectResource) {
        return repository.save(projectResource);
    }

    @Override
    public List<ProjectResources> findByProject(Project project){
        return repository.findByProject(project);
    }

    @Override
    public List<ProjectResources> findByResource(Resource resource){
        return repository.findByResource(resource);
    }
}
