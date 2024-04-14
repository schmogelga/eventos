package com.schmogel.inscricoesapi.application.security;

import com.schmogel.inscricoesapi.application.client.AuthClient;
import feign.FeignException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenValidationFilter implements Filter {

    private final AuthClient authClient;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

      HttpServletRequest servletRequest = (HttpServletRequest) request;
      HttpServletResponse servletResponse = (HttpServletResponse) response;

        try {
            String username = authClient.validarToken(servletRequest.getHeader("Authorization"));
            servletRequest.setAttribute("username", username);
            chain.doFilter(request, response);
        } catch (FeignException ex) {
            servletResponse.setStatus(ex.status());
        }
    }
}
