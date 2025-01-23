package com.foodcourt.foodcourtmicro.domain.spi;

public interface IUserPersistencePort {
    Boolean userRole(Long id, String role);
}
