package ResourceManager.Service.Impl;


import ResourceManager.entity.*;
import ResourceManager.Service.ProjectColumnService;

import ResourceManager.enums.Type;
import ResourceManager.repository.ProjectColumnRepository;
import ResourceManager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectColumnServiceImpl implements ProjectColumnService {
    @Autowired
    ProjectColumnRepository repository;
    @Autowired
    ProjectRepository project_repo;

    @Override
    public ProjectColumns addColumnByProject(Integer project_id, String column_name,String type) {
        Project project=project_repo.findById(project_id).orElse(null);
        if(project ==null){
            System.out.println("Project ID is not valid");
            return null;
        }
        ProjectColumns column=new ProjectColumns();
        column.setProject(project);
        column.setColumn_name(column_name);

        if(type=="Number"){
            column.setType(Type.Number);
        }
        if(type=="Text"){
            column.setType(Type.Text);
        }
        if(type=="Formula"){
            column.setType(Type.Formula);
        }
        ProjectColumns result=repository.save(column);
        return result;
    }

    @Override
    public Boolean deleteColumn(Integer column_id){
        ProjectColumns column=repository.findById(column_id).orElse(null);
        if (column == null) {
            System.out.println("column not exist");
            return false;
        }
        repository.deleteById(column_id);
        return true;
    }

    @Override
    public ProjectColumns getColumnById(Integer column_id){
        /*if(!repository.existsById(column_id)){
            System.out.println();
        }*/
        ProjectColumns projectColumns= repository.findById(column_id).orElse(null);
        return projectColumns;
    }

    @Override
    public List<ProjectColumns> getAllColumns(){
        return repository.findAll();
    }

    @Override
    public ProjectColumns save(ProjectColumns projectColumn) {
        return repository.save(projectColumn);
    }
    @Override
    public List<ProjectColumns> findByProject(Project project){
        return repository.findByProject(project);
    }
    }

