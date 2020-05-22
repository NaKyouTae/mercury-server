package com.competition.jpa.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.jpa.model.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	List<UserRole> findByUserName(String username);
	
	UserRole findByRoleName(String rolename);
}
