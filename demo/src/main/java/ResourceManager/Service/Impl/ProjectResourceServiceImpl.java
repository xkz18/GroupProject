package ResourceManager.Service.Impl;

import ResourceManager.repository.*;
import ResourceManager.entity.*;
import ResourceManager.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository repository;

    @Autowired
    ProjectRepository project_repo;

    @Autowired
    ResourceRepository resource_repo;

    @Override
    public ProjectResources addProjectResource(Integer project_id, Integer resource_id){
        Project project=project_repo.findById(project_id).orElse(null);
            if(project ==null){
            System.out.println("Project ID is not valid");
            return null;
        }
        Resource resource=resource_repo.findById(resource_id).orElse(null);
        if(resource==null){
            System.out.println("Resource ID is not valid");
            return null;
        }
        ProjectResources projectResources=new ProjectResources();
        projectResources.setProject(project);
        projectResources.setResource(resource);
        projectResources.setTime_created(LocalDate.now());

        ProjectResources result=repository.save(projectResources);
        return result;
    }

    @Override
    public boolean deleteProjectResource(Integer record_id){
        ProjectResources record=repository.findById(record_id).orElse(null);
        if (record == null) {
            System.out.println("record not exist");
            return false;
        }
        repository.deleteById(record_id);
        return true;
    }

    @Override
    public ProjectResources getProjectResourceById(Integer record_id){
        ProjectResources projectResources= repository.findById(record_id).orElse(null);
        return projectResources;
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
