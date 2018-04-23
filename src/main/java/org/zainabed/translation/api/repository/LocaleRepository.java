package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zainabed.translation.api.model.Locale;

public interface LocaleRepository extends JpaRepository<Locale, Long> {

}
