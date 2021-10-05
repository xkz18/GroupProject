package com.example.demo;


import com.example.demo.Enums.*;
import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import com.example.demo.Service.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;



//@ComponentScan(basePackageClasses = {ProjectColumnService.class, ProjectResourceService.class})
@RunWith(SpringRunner.class)
@SpringBootTest
class ResourceManagerApplicationTests {
	@Autowired
	private ProjectColumnService service_column;

	@Autowired
	private ProjectResourceService service_PR;

	@Autowired
	private ProjectColumnRepository column_repository;

	@Autowired
	private ProjectResourceRepository projectResource_repository;

	@Autowired
	private ProjectColumnRepository repository2;
	@Autowired
	private UserRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	public void saveTest(){

		for(Type c : Type.values()) {
			System.out.println(c.getCode());
			System.out.println(String.valueOf(c).equals("Text"));
		}
		Assert.assertTrue(true);
	}

}
