package com.example.demo.Service.impl;

import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ProjectColumns getColumn(Integer column_id){
        return repository.getById(column_id);
    }

    @Override
    public List<ProjectColumns> getAllColumns(){
        return repository.findAll();
    }
}
