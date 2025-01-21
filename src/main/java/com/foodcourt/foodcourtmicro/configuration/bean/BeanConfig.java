package com.foodcourt.foodcourtmicro.configuration.bean;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.adapter.RestaurantAdapter;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper.IRestaurantMapperEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository.IRestaurantRepository;
import com.foodcourt.foodcourtmicro.domain.api.IRestaurantServicePort;
import com.foodcourt.foodcourtmicro.domain.api.usecase.RestaurantUseCase;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantMapperEntity restaurantMapperEntity;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantAdapter(restaurantRepository, restaurantMapperEntity);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());

    }
}