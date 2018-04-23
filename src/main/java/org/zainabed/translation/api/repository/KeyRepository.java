package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.zainabed.translation.api.model.Key;

@Component
public interface KeyRepository extends JpaRepository<Key, Long> {

}
