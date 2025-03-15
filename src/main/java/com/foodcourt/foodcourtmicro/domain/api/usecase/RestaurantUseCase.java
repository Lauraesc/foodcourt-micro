package com.foodcourt.foodcourtmicro.domain.api.usecase;

import com.foodcourt.foodcourtmicro.domain.api.IRestaurantServicePort;
import com.foodcourt.foodcourtmicro.domain.exception.InvalidUserRoleException;
import com.foodcourt.foodcourtmicro.domain.exception.NameAlreadyExistsException;
import com.foodcourt.foodcourtmicro.domain.exception.NitAlreadyExistsException;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import com.foodcourt.foodcourtmicro.domain.spi.IAuthPersistencePort;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import com.foodcourt.foodcourtmicro.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserPersistencePort userPersistencePort;
    private final IAuthPersistencePort authPersistencePort;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {

        validate(restaurant);
        findUser(restaurant.getOwnerId(), "OWNER");
        System.out.println(authPersistencePort.getIdByToken());

        return restaurantPersistencePort.saveRestaurant(restaurant);
    }

    private void findUser(Long id, String role) {
        Boolean userRole = userPersistencePort.userRole(id, role);
        if (!userRole) {
            throw new InvalidUserRoleException("El usuario no es válido");
        }
    }

    private void validate(Restaurant restaurant) {

        Optional<Restaurant> optionalNit = restaurantPersistencePort.findByNit(restaurant.getNit());
        Optional<Restaurant> optionalName = restaurantPersistencePort.findByName(restaurant.getName());

        if (optionalNit.isPresent()) {
            throw new NitAlreadyExistsException("El NIT ya existe");
        }
        if (optionalName.isPresent()) {
            throw new NameAlreadyExistsException("El nombre ya existe");
        }
    }


}
