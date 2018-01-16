package org.ps.mps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ps.MpsApplication;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {MpsApplication.class},
				initializers = ConfigFileApplicationContextInitializer.class)
@DirtiesContext

public class MpsApplicationTests {

	@BeforeClass
	public static void start() {

	}

	@AfterClass
	public static void end() {

	}

	@Test
	public void contextLoads() {
	}

}
