package org.zainabed.translation.api.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KeyTest extends ModelTestConfig {

	Key key;
	
	@Before
	public void beforeEach() {
		key= new Key();
		key.setName("valid.key.name");
		key.setDescription("Valid key description");
	}
	
	@After
	public void afterEach() {
		key=null;
	}
	
	@Test
	public void shouldPassCauseValidEntity(){
		verifyModel(key, 0);
	}
	
	@Test
	public void shouldFailCauseNameIsNull(){
		key.setName(null);
		verifyModel(key, 1);
	}
	
	@Test
	public void shouldFailCauseNameLengthIsLessThen5(){
		key.setName("abcd");
		verifyModel(key, 1);
	}
	
	@Test
	public void shouldFailCauseNameLengthIsMoreThen50() {
		key.setName("123456789012345678901234567890123456789012345678901");
		verifyModel(key, 1);
		
	}
	
	@Test
	public void shouldFailCauseDescriptionIsNull(){
		key.setDescription(null);
		verifyModel(key, 1);
	}
	
	@Test
	public void shouldFailCauseDescriptionLengthIsLessThen5(){
		key.setDescription("abcd");
		verifyModel(key, 1);
	}
	
	@Test
	public void shouldFailCauseDescriptionLengthIsMoreThen100() {
		key.setDescription("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		verifyModel(key, 1);
		
	}
}
