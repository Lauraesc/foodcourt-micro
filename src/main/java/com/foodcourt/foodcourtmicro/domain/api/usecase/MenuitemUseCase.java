package com.foodcourt.foodcourtmicro.domain.api.usecase;

import com.foodcourt.foodcourtmicro.domain.api.IMenuitemServicePort;
import com.foodcourt.foodcourtmicro.domain.exception.NameAlreadyExistsException;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import com.foodcourt.foodcourtmicro.domain.spi.IMenuitemPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class MenuitemUseCase implements IMenuitemServicePort {

    private final IMenuitemPersistencePort menuitemPersistencePort;

    @Override
    public Menuitem saveMenuitem(Menuitem menuitem) {
        validate(menuitem);

        return menuitemPersistencePort.saveMenuitem(menuitem);
    }

    private void validate(Menuitem menuitem) {
        Optional<Menuitem> optionalName = menuitemPersistencePort.findByName(menuitem.getName());

        if (optionalName.isPresent()) {
            throw new NameAlreadyExistsException("El nombre del plato ya existe");
        }
    }



}
