package lottery.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.inject.Inject;

import lottery.backend.controller.ContenderController;
import lottery.backend.domain.Contender;
import lottery.backend.persistence.ContenderPersistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LotteryApplication.class)
@WebAppConfiguration
public class LotteryApplicationTests {

	@Inject
	ContenderController contenderController;
	@Inject
	ContenderPersistence contenderPersistence;

	@Test
	public void contextLoads() {}

	@Test
	public void testCreateContender() {

		Contender contender = contenderController.create("John", "Doe");

		assertNotNull(contender);
		assertEquals("John", contender.getFirstname());
		assertEquals("Doe", contender.getLastname());

		contenderPersistence.deleteAll();
	}

	@Test
	public void testGetAllContenders() {

		contenderController.create("John", "Doe");
		contenderController.create("Mary", "Jane");
		contenderController.create("Peter", "Parker");

		assertEquals(3, contenderController.getAllContenders().size());

		contenderPersistence.deleteAll();
	}

	@Test
	public void testDrawWinner() {

		contenderController.create("John", "Doe");
		contenderController.create("Mary", "Jane");
		contenderController.create("Peter", "Parker");

		String winnerName = contenderController.drawWinner();

		assertNotNull(winnerName);
		assertTrue(Arrays.asList("John Doe", "Mary Jane", "Peter Parker").contains(winnerName));

		contenderPersistence.deleteAll();
	}

}
