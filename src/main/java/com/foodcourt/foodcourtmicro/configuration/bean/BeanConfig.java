package com.foodcourt.foodcourtmicro.configuration.bean;

import com.foodcourt.foodcourtmicro.adapters.driven.feign.adapter.UserAdapter;
import com.foodcourt.foodcourtmicro.adapters.driven.feign.client.IUserClient;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.adapter.MenuitemAdapter;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.adapter.RestaurantAdapter;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper.IMenuitemMapperEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper.IRestaurantMapperEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository.IMenuitemRepository;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository.IRestaurantRepository;
import com.foodcourt.foodcourtmicro.domain.api.IMenuitemServicePort;
import com.foodcourt.foodcourtmicro.domain.api.IRestaurantServicePort;
import com.foodcourt.foodcourtmicro.domain.api.usecase.MenuitemUseCase;
import com.foodcourt.foodcourtmicro.domain.api.usecase.RestaurantUseCase;
import com.foodcourt.foodcourtmicro.domain.spi.IMenuitemPersistencePort;
import com.foodcourt.foodcourtmicro.domain.spi.IRestaurantPersistencePort;
import com.foodcourt.foodcourtmicro.domain.spi.IUserPersistencePort;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantMapperEntity restaurantMapperEntity;
    private final IUserClient userClient;
    private final IMenuitemRepository menuitemRepository;
    private final IMenuitemMapperEntity menuitemMapperEntity;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantAdapter(restaurantRepository, restaurantMapperEntity);
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userClient);
    }


    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort(), userPersistencePort());

    }

    @Bean
    public IMenuitemPersistencePort menuitemPersistencePort() {
        return new MenuitemAdapter(menuitemRepository, menuitemMapperEntity);
    }

    @Bean
    public IMenuitemServicePort menuitemServicePort() {
        return new MenuitemUseCase(menuitemPersistencePort(), restaurantPersistencePort());
    }

}