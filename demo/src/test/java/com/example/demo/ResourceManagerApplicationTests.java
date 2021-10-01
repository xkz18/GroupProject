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
		User user=new User();
		Date date=new Date(System.currentTimeMillis());
		System.out.println(date);
		//user.setDateCreated(date);
		//user.setId(1);
		user.setUsername("test");
		System.out.println(user);
		repository.save(user);
	}

	@Test
	public void saveTest(){
		Project project=new Project();
		project.setId(1);
		Date date=new Date(System.currentTimeMillis());
		//project.setDateCreated(date);
		//System.out.println(project);

		ProjectColumns projectColumn=new ProjectColumns();
		projectColumn.setProject(project);
		projectColumn.setColumn_id(2);
		projectColumn.setType(Type.Text);
		projectColumn.setColumn_name("new");

		for(Type c : Type.values()) {
			System.out.println(c.getCode());
			System.out.println(c);
		}
		System.out.println(Type.Formula);
		//ProjectColumns result = column_repository.save(projectColumn);
		//Assert.assertNotNull(result);

		/*ResourceDetails detail=new ResourceDetails();
		detail.setDetail_id(3);
		ResourceDetails detail2=new ResourceDetails();
		detail2.setDetail_id(4);
		List<ResourceDetails> list=new ArrayList<>();
		list.add(detail);
		list.add(detail2);
		projectColumn.setResourceDetails(list);

		ProjectColumns result = column_repository.save(projectColumn);
		Assert.assertNotNull(result);
		System.out.println(projectColumn);*/
	}

}
