package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.JwtResponseDTO;
import com.webapp.projeto.application.dto.RegisterRequestDTO;
import com.webapp.projeto.application.security.AuthManager;
import com.webapp.projeto.application.security.DataLoader;
import com.webapp.projeto.application.security.JwtService;
import com.webapp.projeto.domain.model.UserInfo;
import com.webapp.projeto.domain.model.UserRole;
import com.webapp.projeto.domain.service.RoleService;
import com.webapp.projeto.infrastructure.repository.RoleRepository;
import com.webapp.projeto.infrastructure.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final DataLoader dataLoader;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final AuthManager authManager;


    @Override
    public JwtResponseDTO login(@RequestHeader("Authorization") String basicAuth){

        dataLoader.loadInitialData();
        String[] credentials = authManager.decodeBasicAuth(basicAuth);

        String username = credentials[0];
        String password = credentials[1];

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if(authentication.isAuthenticated()){
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(username))
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

    @Override
    public UserInfo criarUsuario(@RequestBody RegisterRequestDTO registerRequestDTO){

        String encodedPassword =  new BCryptPasswordEncoder().encode(registerRequestDTO.getPassword());
        UserInfo user = new UserInfo(
                null,
                registerRequestDTO.getUsername(),
                registerRequestDTO.getEmail(),
                registerRequestDTO.getNome(),
                encodedPassword,
                Set.of(roleService.recuperarOuCriarUserRolePorNome("ADMIN")));

        return userRepository.save(user);
    }

    @Override
    public String validateToken(HttpServletRequest request){
        return (String) request.getAttribute("username");
    }
}
