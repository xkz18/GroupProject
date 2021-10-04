package ResourceManager;
import ResourceManager.entity.Resource;
import ResourceManager.repository.ResourceRepository;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceRepositoryTest{

    @Autowired
    ResourceRepository resourceRepository;


    @Test
    public void saveTest(){
        Resource resource = new Resource();
        resource.setResourceId(1);
        resource.setTimeCreated(LocalDate.now());
        Resource result = resourceRepository.save(resource);
        Assert.assertNotEquals(null, result);
    }


}
