package ResourceManager.Service;

import ResourceManager.entity.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {

    @Autowired ResourceService resourceService;

    @Test
    public void getAllResource() {
        List<Resource> result=resourceService.getAllResource();
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void deleteResource(){
        boolean result= resourceService.deleteResource(17);
        Assert.assertTrue(result);
    }

    @Test
    public void getResource() {
        Resource result= resourceService.getResource(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void saveResource() {
        Resource resource = new Resource();
        resource.setResourceId(5);
        resource.setTimeCreated(LocalDate.now());
        Resource result = resourceService.saveResource(resource);
        Assert.assertNotNull(result);
    }
}