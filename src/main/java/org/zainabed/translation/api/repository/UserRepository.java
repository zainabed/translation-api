package org.zainabed.translation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.zainabed.translation.api.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
