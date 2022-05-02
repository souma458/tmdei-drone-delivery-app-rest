package pt.isep.tmdei.schedulerservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pt.isep.tmdei.schedulerservice.controller.SchedulerController;

@SpringBootTest
class SchedulerServiceApplicationTests {

	@Autowired
	SchedulerController sc;

	@Test
	void contextLoads() {
		assertNotNull(sc);
	}

}
