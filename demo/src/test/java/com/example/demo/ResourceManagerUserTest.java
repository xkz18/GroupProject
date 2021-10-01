package com.example.demo;


import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/*@ComponentScan(basePackageClasses = {UserRepository.class})*/

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@ComponentScan(basePackageClasses = {UserRepository.class, User.class})
public class ResourceManagerUserTest {
    @Autowired
    private UserRepository repository;
    int count=0;
    @Test
    public void saveTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin0");
        user.setPassword("save");
        User result = repository.save(user);
        count++;
        Assert.assertNotNull(result);

    }
    @Test
    public void findByIdTest(){
        User user = new User();
        //user.setId(1);
        user.setUsername("admin");
        user.setPassword("find");
        repository.save(user);
        count++;
        User result = repository.findById(1).orElse(null);
        Assert.assertNotNull(result);
    }
    @Test
    public void findAllTest(){
        User user = new User();
        //user.setId(1);
        user.setUsername("admin1");
        user.setPassword("123");
        User user1 = new User();
        //user1.setId(2);
        user1.setUsername("admin2");
        user1.setPassword("1234");
        repository.save(user);
        repository.save(user1);
        List<User> result = repository.findAll();
        count+=2;
        int expected = count;
        int actual = result.size();
        Assert.assertEquals(expected,actual);
    }
}
