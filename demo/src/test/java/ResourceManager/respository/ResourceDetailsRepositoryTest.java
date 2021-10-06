package ResourceManager.respository;

import ResourceManager.entity.ResourceDetails;
import ResourceManager.repository.ResourceDetailsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDetailsRepositoryTest{

    @Autowired
    ResourceDetailsRepository resourceDetailsRepository;

    @Test
    public void saveTest(){
        ResourceDetails resourceDetails = new ResourceDetails();
        resourceDetails.setDetail_id(1);
        resourceDetails.setTime_created(LocalDate.now());
        ResourceDetails result = resourceDetailsRepository.save(resourceDetails);
        Assert.assertNotEquals(null, result);
    }


}
