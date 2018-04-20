package org.zainabed.translation.api.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zainabed.translation.api.model.Locale;

public class LocaleTest extends ModelTestConfig{

	Locale locale;
	
	@Before
	public void beforeEach() {
		locale = new Locale();
		locale.setCode("sv-SE");
		locale.setName("Sweden - English");
	}
	
	@After
	public void afterEach() {
		locale = null;
	}
	
	@Test
	public void shouldPassCauseValidModel(){
		verifyModel(locale, 0);
	}
	
	@Test
	public void shouldFailCauseCodeIsNull(){
		locale.setCode(null);
		verifyModel(locale, 1);
	}
	
	@Test
	public void shouldFialCauseCodeLengthIsLessThen5(){
		locale.setCode("se-S");
		verifyModel(locale,1);
	}
	
	@Test
	public void shouldFialCauseCodeLengthIsMoreThen6(){
		locale.setCode("se-SEWE");
		verifyModel(locale,1);
	}
	
	@Test 
	public void shouldFailCauseNameIsNull() {
		locale.setName(null);
		verifyModel(locale, 1);
	}
	
	@Test
	public void shouldFailCauseNameLengthIslessThen5() {
		locale.setName("abcd");
		verifyModel(locale, 1);
	}
	
	@Test
	public void shouldFailCauseNameLengthIsMoreThen20(){
		locale.setName("123456789012345678901");
		verifyModel(locale, 1);
	}
}
