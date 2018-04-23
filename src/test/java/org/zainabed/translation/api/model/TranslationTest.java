package org.zainabed.translation.api.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TranslationTest extends ModelTestConfig {

	private Translation translation;

	@Before
	public void beforeEach() {
		translation = new Translation();
		translation.setKey(new Key());
		translation.setLocale(new Locale());
		translation.setContent("test content");
	}

	@After
	public void afterEach() {
		translation = null;
	}

	@Test
	public void shouldPassCauseValidModel() {
		verifyModel(translation, 0);
	}

	@Test
	public void shouldFailCauseContentIsNull() {
		translation.setContent(null);
		verifyModel(translation, 1);
	}

		
	@Test
	public void shouldFailCauseKeyIsNull() {
		translation.setKey(null);
		verifyModel(translation, 1);
	}
	
	@Test
	public void shouldFailCauseLocaleIsNull() {
		translation.setLocale(null);
		verifyModel(translation, 1);
	}
}
