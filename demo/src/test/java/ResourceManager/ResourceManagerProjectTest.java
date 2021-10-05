package ResourceManager;

import ResourceManager.entity.Project;
import ResourceManager.entity.User;
import ResourceManager.repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ResourceManagerProjectTest {
    @Autowired
    private ProjectRepository repository;

    @Test
    public void saveTest(){
        Project project = new Project();
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123");
        project.setId(1);
        project.setUser(user);
        project.setDateCreated(LocalDate.now());
        Project result = repository.save(project);
        Assert.assertNotNull(result);
    }
    @Test
    public void findIdTest(){
        Project project = new Project();
        project.setId(1);
        project.setDateCreated(LocalDate.now());
        repository.save(project);
        Project result = repository.findById(1).orElse(null);
        Assert.assertNotNull(result);
    }
    @Test
    public void findAllTest(){
        Project project = new Project();
        Project project1 = new Project();
        project.setId(1);
        project1.setId(2);
        project.setDateCreated(LocalDate.now());
        project1.setDateCreated(LocalDate.now());
        repository.save(project);
        repository.save(project1);
        List<Project> result = repository.findAll();
        int expected =2;
        int actual= result.size();
        Assert.assertEquals(expected,actual);
    }
}
