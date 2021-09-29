package com.example.demo;


import ResourceManager.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
class ResourceManagerApplicationTests {

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

}
