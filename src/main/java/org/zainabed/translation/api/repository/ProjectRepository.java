package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zainabed.translation.api.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
