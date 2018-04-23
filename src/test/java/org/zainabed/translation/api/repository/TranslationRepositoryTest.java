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
import org.zainabed.translation.api.model.Translation;
import org.zainabed.translation.api.model.Key;
import org.zainabed.translation.api.model.Locale;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TranslationRepositoryTest {

	@Autowired
	private TranslationRepository repository;

	private Translation translation;
	private Translation testTranslation;
	private Key key;
	private Locale locale;

	@Before
	public void beforeEach() {
		// Key model
		key = new Key();
		key.setName("test key");
		key.setDescription("test description");
		key.setCreatedAt(new Date());

		// Locale model
		locale = new Locale();
		locale.setName("test name");
		locale.setCode("sv-SE");
		locale.setCreatedAt(new Date());

		// Translation model
		translation = new Translation();
		translation.setContent("test content");
		translation.setKey(key);
		translation.setLocale(locale);
		translation.setCreatedAt(new Date());

		// Insert into DB
		testTranslation = repository.saveAndFlush(translation);
	}

	@After
	public void afterEach() {
		repository.deleteAll();
	}

	@Test
	public void findOneShouldPassCauseModelIsInsertedIntoDB() {
		testTranslation = repository.findOne(translation.getId());
		assertNotNull(testTranslation);
	}

	@Test
	public void shouldUpdateModel() {
		String udateContent = "updated content";
		translation.setContent(udateContent);
		testTranslation = repository.save(translation);
		assertEquals(testTranslation.getContent(), udateContent);
	}

	@Test
	public void shouldDeleteModel() {
		repository.delete(translation.getId());
		testTranslation = repository.findOne(translation.getId());
		assertNull(testTranslation);
	}
}
