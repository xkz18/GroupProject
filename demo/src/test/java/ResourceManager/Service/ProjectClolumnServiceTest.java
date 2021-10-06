package ResourceManager.Service;

import ResourceManager.enums.Type;
import ResourceManager.entity.Project;
import ResourceManager.entity.ProjectColumns;
import ResourceManager.Service.ProjectColumnService;
import ResourceManager.Service.ProjectResourceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectClolumnServiceTest {
    @Autowired
    private ProjectColumnService service_column;

    @Test
    public void addTest(){
        ProjectColumns column=new ProjectColumns();
        Project project=new Project();
        project.setId(1);

        column.setProject(project);
        column.setType(Type.Formula);
        column.setColumn_name("serviceTest1");
        /*ProjectColumns result=service_column.addColumn(column);*/
        /*Assert.assertNotNull(result);*/
    }

    @Test
    @Transactional
    public void getTest(){
        /*ProjectColumns result=service_column.getColumn(1);*/
        /*System.out.println(result);
        Assert.assertNotNull(result);*/
    }

    @Test
    public void deleteTest(){
        boolean result=service_column.deleteColumn(1);
        Assert.assertTrue(result);
    }

    @Test
    public void getAllTest(){
        List<ProjectColumns> result=service_column.getAllColumns();
        Assert.assertEquals(1, result.size());
    }
}
