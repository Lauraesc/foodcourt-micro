package com.foodcourt.foodcourtmicro.domain.api.usecase;

import com.foodcourt.foodcourtmicro.domain.api.IRestaurantServicePort;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {

        validate(restaurant);

        return restaurantPersistencePort.saveRestaurant(restaurant);
    }
    private void validate(Restaurant restaurant) {

        Optional<Restaurant> optionalNit = restaurantPersistencePort.findByNit(restaurant.getNit());
        Optional<Restaurant> optionalName = restaurantPersistencePort.findByName(restaurant.getName());

        if (optionalNit.isPresent()) {
            throw new IllegalArgumentException("El NIT ya existe");
        }
        if (optionalName.isPresent()) {
            throw new IllegalArgumentException("El nombre ya existe");
        }
    }


}
