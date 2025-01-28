package com.foodcourt.foodcourtmicro.domain.spi;

import com.foodcourt.foodcourtmicro.domain.model.Menuitem;

import java.util.Optional;

public interface IMenuitemPersistencePort {

    Menuitem saveMenuitem(Menuitem menuitem);
    Optional<Menuitem> findByName(String name);
}
