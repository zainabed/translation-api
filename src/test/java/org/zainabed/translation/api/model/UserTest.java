package org.zainabed.translation.api.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zainabed.translation.api.model.User;

public class UserTest extends ModelTestConfig {

	User user;
	
	@Before
	public void beforeEach(){
		user = new User();
		user.setId(1L);
		user.setUsername("zain");
		user.setEmail("zain@test.com");
		user.setPassword("sfsfd2223");
		user.setStatus("active");
	}
	
	@After
	public void afterEach() {
		user = null;
	}
	
	@Test
	public void shouldPassCauseValidModelObject() {
		verifyModel(user, 0);
	}
	
	
	
}
