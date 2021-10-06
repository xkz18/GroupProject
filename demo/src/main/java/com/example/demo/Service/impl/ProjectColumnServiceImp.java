package com.example.demo.Service.impl;

import com.example.demo.Enums.Type;
import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectColumnServiceImp implements ProjectColumnService {
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
