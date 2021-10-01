package com.example.demo;

import com.example.demo.Enums.Type;
import com.example.demo.Repository.ProjectColumnRepository;
import com.example.demo.ResourceManager.model.Project;
import com.example.demo.ResourceManager.model.ProjectColumns;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceManagerProjectColumnTest {
    @Autowired
    private ProjectColumnRepository column_repository;

    @Test
    public void saveTest(){
        Project project=new Project();
        project.setId(1);

        ProjectColumns projectColumn=new ProjectColumns();
        projectColumn.setProject(project);
        //projectColumn.setColumn_id(2);
        projectColumn.setType(Type.Formula);
        projectColumn.setColumn_name("new");
        ProjectColumns result = column_repository.save(projectColumn);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByIdTest(){
        ProjectColumns result=column_repository.findById(1).orElse(null);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAllTest(){
        List<ProjectColumns> result=column_repository.findAll();
        Assert.assertEquals(2, result.size());
    }
}
