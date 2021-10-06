package ResourceManager.Service;

import ResourceManager.entity.Resource;
import ResourceManager.entity.ResourceDetails;
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
public class ResourceDetailsServiceTest {

    @Autowired ResourceDetailsService resourceDetailsService;
    @Test
    public void getAllDetails() {
        List<ResourceDetails> result=resourceDetailsService.getAllDetails();
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void getDetails() {
        ResourceDetails result= resourceDetailsService.getDetails(4);
        Assert.assertNotNull(result);
    }



}