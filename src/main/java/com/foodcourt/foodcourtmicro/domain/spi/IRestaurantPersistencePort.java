package com.foodcourt.foodcourtmicro.domain.spi;

import com.foodcourt.foodcourtmicro.domain.model.Restaurant;

import java.util.Optional;

public interface IRestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);
    Optional<Restaurant> findByNit(Long nit);
    Optional<Restaurant> findByName(String name);
    Restaurant findRestaurantById(Long id);
}
