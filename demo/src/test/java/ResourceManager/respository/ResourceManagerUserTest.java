package ResourceManager.respository;

import ResourceManager.entity.User;
import ResourceManager.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceManagerUserTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void saveTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123");
        User result = repository.save(user);
        Assert.assertNotNull(result);
    }




    @Test
    public void findByIdTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123");
        repository.save(user);
        User result = repository.findById(1).orElse(null);
        Assert.assertNotNull(result);
    }
    @Test
    public void findAllTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123");
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("admin1");
        user1.setPassword("1234");
        repository.save(user);
        repository.save(user1);
        List<User> result = repository.findAll();
        int expected = 2;
        int actual = result.size();
        Assert.assertEquals(expected,actual);
    }
}
