package org.zainabed.translation.api.resource;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zainabed.translation.api.model.Project;

@RestController
@RequestMapping("/")
public class ModelResource<M> {

	protected JpaRepository<M, Long> repository;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public M getOne(@PathVariable("id") Long id) {
		return repository.findOne(id);

	}
}
