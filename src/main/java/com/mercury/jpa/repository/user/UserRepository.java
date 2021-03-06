package com.mercury.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByIdx(String idx);
	User findByUsername(String username);
	User findByEmail(String email);
	User findByPassword(String password);
}
