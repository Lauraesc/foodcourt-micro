package com.foodcourt.foodcourtmicro.adapters.driven.auth;

import com.foodcourt.foodcourtmicro.domain.spi.IAuthPersistencePort;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class AuthAdapter implements IAuthPersistencePort {

    @Override
    public Long getIdByToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Long) authentication.getPrincipal();
    }
}
