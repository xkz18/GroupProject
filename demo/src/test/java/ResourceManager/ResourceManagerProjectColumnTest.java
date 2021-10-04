package ResourceManager;

import ResourceManager.enums.Type;
import ResourceManager.repository.ProjectColumnRepository;
import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        // projectColumn.setColumn_id(1);
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
