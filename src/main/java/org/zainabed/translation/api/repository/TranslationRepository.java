package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zainabed.translation.api.model.Translation;

public interface TranslationRepository extends JpaRepository<Translation, Long> {

}
