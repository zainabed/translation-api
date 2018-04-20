package org.zainabed.translation.api.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zainabed.translation.api.model.Project;

public class ProjectTest extends ModelTestConfig{

	Project project;

	@Before
	public void beforeEach() {
		project = new Project();
		project.setName("test project");
		project.setDescription("test description");
	}

	@After
	public void afterEach() {
		project = null;
	}
	
	@Test
	public void shouldPassCauseValidModel() {
		verifyModel(project, 0);
	}
	
	@Test
	public void shouldFailCauseEmptyName(){
		project.setName(null);
		verifyModel(project, 1);
	}
	
	@Test
	public void shouldFailCauseNameSizeIsLessThen5() {
		project.setName("abcd");
		verifyModel(project, 1);
	}
	
	@Test
	public void shouldFailCauseNameSizeIsMoreThen15(){
		project.setName("1234567890123456");
		verifyModel(project, 1);
	}
	
	@Test
	public void shouldFailCauseEmptyDescription(){
		project.setDescription(null);
		verifyModel(project, 1);
	}
	
	@Test
	public void shouldFailCauseDescriptionSizeIsLessThen10() {
		project.setDescription("123456789");
		verifyModel(project, 1);
	}
	
	@Test
	public void shouldFailCauseDescriptionSizeIsMoreThen200(){
		project.setDescription("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		verifyModel(project, 1);
	}
}
