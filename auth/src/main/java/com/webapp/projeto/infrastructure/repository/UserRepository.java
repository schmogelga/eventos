package com.webapp.projeto.infrastructure.repository;

import com.webapp.projeto.domain.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}