package Service.impl;

import Repository.ProjectColumnRepository;
import ResourceManager.model.ProjectColumns;
import Service.ProjectColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectColumnServiceImp implements ProjectColumnService {
    @Autowired
    ProjectColumnRepository repository;

    @Override
    public ProjectColumns addColumn(ProjectColumns projectColumn){
        return repository.save(projectColumn);
    }

    @Override
    public void deleteColumn(Integer column_id){
        repository.deleteById(column_id);
    }

    @Override
    public ProjectColumns getColumn(Integer column_id){
        return repository.getById(column_id);
    }

    @Override
    public List<ProjectColumns> getAllColumns(){
        return repository.findAll();
    }
}
