package com.foodcourt.foodcourtmicro.adapters.driven.feign.adapter;

import com.foodcourt.foodcourtmicro.adapters.driven.feign.client.IUserClient;
import com.foodcourt.foodcourtmicro.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {
    private final IUserClient userClient;
    @Override
    public Boolean userRole(Long id, String role) {
        return userClient.userRole(id, role);
    }
}
