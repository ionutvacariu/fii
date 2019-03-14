package eu.unicredit.fii.practic.fii.controller;

import eu.unicredit.fii.practic.fii.controller.UserController;
import eu.unicredit.fii.practic.fii.model.User;
import eu.unicredit.fii.practic.fii.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FiiApplicationTests {

	@Autowired
	UserController userController;

	@Test
	public void invokeAOPStuff() {

		userController.newUser(new User());
	}

}
