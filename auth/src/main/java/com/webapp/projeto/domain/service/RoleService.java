package com.webapp.projeto.domain.service;

import com.webapp.projeto.domain.model.UserRole;
import com.webapp.projeto.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public UserRole recuperarOuCriarUserRolePorNome(String nome){

        Optional<UserRole> roleExistente = roleRepository.findUserRoleByName(nome);
        if(roleExistente.isEmpty()){
            UserRole userRole = new UserRole(null, nome);
            roleRepository.save(userRole);
            return userRole;
        }
        return roleExistente.get();
    }
}
