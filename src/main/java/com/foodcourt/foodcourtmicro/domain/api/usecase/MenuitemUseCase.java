package com.foodcourt.foodcourtmicro.domain.api.usecase;

import com.foodcourt.foodcourtmicro.domain.api.IMenuitemServicePort;
import com.foodcourt.foodcourtmicro.domain.exception.NameAlreadyExistsException;
import com.foodcourt.foodcourtmicro.domain.exception.ResourceNotFoundException;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import com.foodcourt.foodcourtmicro.domain.spi.IMenuitemPersistencePort;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class MenuitemUseCase implements IMenuitemServicePort {

    private final IMenuitemPersistencePort menuitemPersistencePort;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    @Override
    public Menuitem saveMenuitem(Menuitem menuitem, Long id_restaurant) {

        validate(menuitem);
        menuitem.setRestaurant(validateRestaurant(id_restaurant));

        return menuitemPersistencePort.saveMenuitem(menuitem);
    }

    private void validate(Menuitem menuitem) {
        Optional<Menuitem> optionalName = menuitemPersistencePort.findByName(menuitem.getName());

        if (optionalName.isPresent()) {
            throw new NameAlreadyExistsException("El nombre del plato ya existe");
        }
    }



    private Restaurant validateRestaurant(Long idRestaurant) {

        Restaurant restaurantFound = restaurantPersistencePort.findRestaurantById(idRestaurant);

        if (restaurantFound == null) {
            throw new ResourceNotFoundException("El restaurante con ID " + idRestaurant + " no existe");
        }

        return restaurantFound;
    }



}
