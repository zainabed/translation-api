package org.zainabed.translation.api.repository;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zainabed.translation.api.model.User;
import org.zainabed.translation.api.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	private User user;
	private User testUser;

	@Before
	public void beforeEach() {
		user = new User();
		user.setUsername("testuser");
		user.setPassword("test password");
		user.setEmail("test@email.com");
		user.setStatus("active");
		user.setCreatedAt(new Date());

		// Insert into DB
		user = repository.save(user);
	}

	@After
	public void afterEach() {
		repository.deleteAll();
	}

	@Test
	public void findOneShouldPassCauseUserIsInsertedIntoDB() {
		testUser = repository.findByUsername(user.getUsername());
		assertEquals(testUser.getId(), user.getId());
	}
}
