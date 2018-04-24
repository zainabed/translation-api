package org.zainabed.translation.api.resource;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.zainabed.translation.api.model.Project;
import org.zainabed.translation.api.repository.ProjectRepository;
import org.zainabed.translation.api.resource.ProjectResource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@WebMvcTest(ProjectResource.class)
@RunWith(SpringRunner.class)
// @SpringBootTest
public class ProjectResourceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProjectRepository repository;

	private Project project;
	private Long projectId = 1L;

	@Before
	public void beforeEach() {
		project = new Project();
		project.setId(projectId);
		project.setName("test project");
		project.setDescription("test description");
		project.setCreatedAt(new Date());
	}

	@After
	public void afterEach() {
		project = null;
	}

	@Test
	public void shouldFetchSingleProjectRecord() throws Exception {
		Mockito.when(repository.findOne(projectId)).thenReturn(project);
		mvc.perform(get("/project/{id}", projectId)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", is(projectId.intValue())));
	}
}
