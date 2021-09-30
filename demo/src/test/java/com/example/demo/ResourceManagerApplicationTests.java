package com.example.demo;


import Repository.ProjectColumnRepository;
import Repository.ProjectResourceRepository;
import ResourceManager.model.*;
import Service.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


//@ComponentScan(basePackageClasses = {ProjectColumnService.class, ProjectResourceService.class})
@RunWith(SpringRunner.class)
class ResourceManagerApplicationTests {
	@Autowired
	private ProjectColumnService service_column;

	@Autowired
	private ProjectResourceService service_PR;

	@Autowired
	private ProjectColumnRepository column_repository;

	@Autowired
	private ProjectResourceRepository projectResource_repository;

	@Test
	void contextLoads() {
		User user=new User();
		Date date=new Date(System.currentTimeMillis());
		System.out.println(date);
		user.setDateCreated(date);
		user.setId(1);
		user.setUsername("test");
		System.out.println(user);
	}

	@Test
	public void saveTest(){
		Project project=new Project();
		project.setId(1);
		Date date=new Date(System.currentTimeMillis());
		project.setDateCreated(date);
		//System.out.println(project);

		ProjectColumns projectColumn=new ProjectColumns();
		projectColumn.setProject(project);
		projectColumn.setColumn_id(2);
		projectColumn.setType(ProjectColumns.Type.Text);
		projectColumn.setColumn_name("new");

		ProjectColumns result = column_repository.save(projectColumn);
		Assert.assertNotNull(result);
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
