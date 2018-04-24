package org.zainabed.translation.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zainabed.translation.api.model.Project;
import org.zainabed.translation.api.repository.ProjectRepository;

//@RestController
//@RequestMapping("/project")
public class ProjectResource extends ModelResource<Project> {

	/*@Autowired
	private ProjectRepository repository;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Project getOne(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}*/

}
