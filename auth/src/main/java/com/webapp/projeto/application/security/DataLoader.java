package com.webapp.projeto.application.security;

import com.webapp.projeto.domain.model.UserInfo;
import com.webapp.projeto.domain.model.UserRole;
import com.webapp.projeto.infrastructure.repository.RoleRepository;
import com.webapp.projeto.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void loadInitialData() {
        if (userRepository.count() == 0) {
            String username = "admin";
            String password = "adminPassword";

            String encodedPassword =  new BCryptPasswordEncoder().encode(password);
            UserInfo user = new UserInfo(null, username, encodedPassword, null, null, null);

            UserRole role = new UserRole(null, "ADMIN");
            roleRepository.save(role);

            user.setRoles(Set.of(role));
            userRepository.save(user);
        }
    }
}
