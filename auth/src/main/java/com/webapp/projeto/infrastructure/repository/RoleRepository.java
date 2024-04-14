package com.webapp.projeto.infrastructure.repository;

import com.webapp.projeto.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, UUID> {

    Optional<UserRole> findUserRoleByName(String name);
}
