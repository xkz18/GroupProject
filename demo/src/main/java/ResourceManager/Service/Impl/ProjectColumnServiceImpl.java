package ResourceManager.Service.Impl;

import ResourceManager.enums.Type;
import ResourceManager.repository.*;
import ResourceManager.entity.*;
import ResourceManager.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectColumnServiceImpl implements ProjectColumnService {
    @Autowired
    ProjectColumnRepository repository;

    @Autowired
    ProjectRepository project_repo;


    @Override
    public ProjectColumns addColumnByProject(Project project, String column_name,String type, String text) {
        //Project project=project_repo.findById(project_id).orElse(null);
        if(project ==null){
            System.out.println("Project ID is not valid");
            return null;
        }
        ProjectColumns column=new ProjectColumns();
        column.setProject(project);
        column.setColumn_name(column_name);

        if(type.equals("Number")){
            column.setType(Type.Number);
        }
        if(type.equals("Text")){
            column.setType(Type.Text);
        }
        if(type.equals("Formula")){
            column.setType(Type.Formula);
        }
        ProjectColumns result=repository.save(column);
        return result;
    }

    @Override
    public ProjectColumns deleteColumn(Integer column_id){
        Optional<ProjectColumns> target=repository.findById(column_id);
        if (target.isPresent()) {
            repository.deleteById(column_id);
            return target.get();
        }
        else {
            return null;
        }
    }

    @Override
    public ProjectColumns getColumnById(Integer column_id){
        Optional<ProjectColumns> target= repository.findById(column_id);
        if(target.isPresent()){
            return target.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<ProjectColumns> getAllColumns(){
        return repository.findAll();
    }

    @Override
    public ProjectColumns save(ProjectColumns projectColumn) {
        //projectColumn.getProject()
        return repository.save(projectColumn);
    }
    @Override
    public List<ProjectColumns> findByProject(Project project){
        return repository.findByProject(project);
    }
}
