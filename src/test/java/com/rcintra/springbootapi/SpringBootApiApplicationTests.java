package com.rcintra.springbootapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
