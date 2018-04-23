package org.zainabed.translation.api.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zainabed.translation.api.model.Key;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KeyRepositoryTest {

	@Autowired
	private KeyRepository repository;
	private Key key;
	private Key testKey;

	@Before
	public void beforeEach() {
		key = new Key();
		key.setName("test key");
		key.setDescription("test description");
		key.setCreatedAt(new Date());
		// Insert into DB
		key = repository.save(key);
	}

	@After
	public void afterEach() {
		repository.deleteAll();
	}

	@Test
	public void findOneShouldPassCauseUserIsInsertedIntoDB() {
		testKey = repository.findOne(key.getId());
		assertNotNull(testKey);
	}

	@Test
	public void updateOneShouldRefelectChanges() {
		String updatedName = "updated name";
		key.setName(updatedName);
		testKey = repository.save(key);
		assertEquals(testKey.getName(), updatedName);
	}

	@Test
	public void deleteShouldRemoveKeyFromDB() {
		repository.delete(key.getId());
		testKey = repository.findOne(key.getId());
		assertNull(testKey);
	}

}
