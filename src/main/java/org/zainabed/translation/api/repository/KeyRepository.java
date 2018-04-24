package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.zainabed.translation.api.model.Key;

@Repository
@RepositoryRestResource(collectionResourceRel="key", path="key")
public interface KeyRepository extends JpaRepository<Key, Long> {

}
