package Service.impl;

import Repository.ProjectResourceRepository;
import ResourceManager.model.ProjectResources;
import Service.ProjectResourceService;
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
