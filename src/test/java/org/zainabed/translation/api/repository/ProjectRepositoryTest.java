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
import org.zainabed.translation.api.model.Project;
import org.zainabed.translation.api.model.ProjectRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryTest {

	@Autowired
	private ProjectRepository repository;
	private Project project;
	private Project testProject;

	@Before
	public void beforeEach() {
		project = new Project();
		project.setName("test project");
		project.setDescription("test description");
		project.setCreatedAt(new Date());
		// Insert into DB
		project = repository.save(project);
	}

	@After
	public void afterEach() {
		repository.deleteAll();
	}

	@Test
	public void findOneShouldPassCauseUserIsInsertedIntoDB() {
		testProject = repository.findOne(project.getId());
		assertNotNull(testProject);
	}

	@Test
	public void updateOneShouldRefelectChanges() {
		String updatedName = "updated name";
		project.setName(updatedName);
		testProject = repository.save(project);
		assertEquals(testProject.getName(), updatedName);
	}

	@Test
	public void deleteShouldRemoveProjectFromDB() {
		repository.delete(project.getId());
		testProject = repository.findOne(project.getId());
		assertNull(testProject);
	}

}
