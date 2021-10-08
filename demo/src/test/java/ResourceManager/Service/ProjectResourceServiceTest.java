package ResourceManager.Service;

import ResourceManager.enums.Type;
import ResourceManager.repository.ProjectRepository;
import ResourceManager.repository.ResourceRepository;
import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.entity.ProjectResources;
import ResourceManager.entity.Resource;
import ResourceManager.Service.ProjectColumnService;
import ResourceManager.Service.ProjectResourceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectResourceServiceTest {
    @Autowired
    private ProjectResourceService service_record;
    @Autowired
    private ResourceRepository resource_repository;
    @Autowired
    private ProjectRepository project_repository;

    @Test
    public void addTest(){
        Project project=new Project();
        project.setId(1);
        //project_repository.save(project);

        Resource resource=new Resource();
        resource.setResourceId(2);
        resource_repository.save(resource);

        /*Resource resource=resource_repository.getById(1);
        if(resource==null)
            Assert.assertTrue(false);*/
        ProjectResources record=new ProjectResources();
        record.setProject(project);
        record.setResource(resource);
        record.setRecord_id(1);
        record.setTime_created(LocalDate.now());
        ProjectResources result=service_record.addProjectResource(project, resource);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void getTest(){
        /*ProjectResources result=service_record.getProjectResource(2);
        System.out.println(result);
        Assert.assertNotNull(result);*/
    }

    @Test
    public void deleteTest(){
       /* boolean result=service_record.deleteProjectResource(2);
        Assert.assertTrue(result);*/
    }

    @Test
    public void getAllTest(){
        List<ProjectResources> result=service_record.getAllProjectResources();
        Assert.assertEquals(1, result.size());
    }
}
