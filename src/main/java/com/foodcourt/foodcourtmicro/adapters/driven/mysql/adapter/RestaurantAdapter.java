package com.foodcourt.foodcourtmicro.adapters.driven.mysql.adapter;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper.IRestaurantMapperEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository.IRestaurantRepository;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantMapperEntity restaurantMapperEntity;
    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantMapperEntity.restaurantEntityToRestaurant(
                restaurantRepository.save(
                        restaurantMapperEntity.restaurantToRestaurantEntity(restaurant)
                )
        );
    }

    @Override
    public Optional<Restaurant> findByNit(Long nit) {
        return restaurantRepository.findByNit(nit)
                .map(restaurantMapperEntity::restaurantEntityToRestaurant);
    }

    @Override
    public Optional<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name)
                .map(restaurantMapperEntity::restaurantEntityToRestaurant);
    }
}
