package org.zainabed.translation.api.repository;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zainabed.translation.api.model.Locale;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocaleRepositoryTest {

	@Autowired
	private LocaleRepository repository;
	private Locale locale;
	private Locale testLocale;

	@Before
	public void beforeEach() {
		locale = new Locale();
		locale.setName("test name");
		locale.setCode("sv-SE");
		locale.setCreatedAt(new Date());

		// Insert into DB
		locale = repository.save(locale);
	}

	@After
	public void afterEach() {
		locale = null;
	}

	@Test
	public void shouldFindModelCauseModelIsInserterdIntoDB() {
		testLocale = repository.findOne(locale.getId());
		assertNotNull(testLocale);
	}

	@Test
	public void shouldUpdateModel() {
		String updatedCode = "fi-FI";
		locale.setCode(updatedCode);
		testLocale = repository.save(locale);
		assertEquals(testLocale.getCode(), updatedCode);
	}

	@Test
	public void shouldDeleteModel() {
		repository.delete(locale.getId());
		testLocale = repository.findOne(locale.getId());
		assertNull(testLocale);
	}
}
