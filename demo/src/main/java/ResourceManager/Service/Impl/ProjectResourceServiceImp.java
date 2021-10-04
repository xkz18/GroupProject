package ResourceManager.Service.Impl;

import ResourceManager.repository.*;
import ResourceManager.entity.*;
import ResourceManager.Service.ProjectResourceService;
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
    public boolean deleteProjectResource(Integer record_id){

        /*repository.deleteById(record_id);*/

        ProjectResources record=repository.findById(record_id).orElse(null);
        if (record == null) {
            System.out.println("record not exist");
            return false;
        }
        repository.deleteById(record_id);
        return true;
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
