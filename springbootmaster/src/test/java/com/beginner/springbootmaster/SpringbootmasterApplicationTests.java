package com.beginner.springbootmaster;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainersConfiguration.class)
// MovieServiceApplicationTests
class SpringbootmasterApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringbootmasterApplicationTests.class);

	@Autowired
	private TestRestTemplate testTemplate;

	@Test
	void contextLoads() {
	}

}
