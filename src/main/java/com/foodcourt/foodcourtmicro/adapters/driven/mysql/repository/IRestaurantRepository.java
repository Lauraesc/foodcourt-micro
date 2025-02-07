package com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.RestaurantEntity;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    Optional<RestaurantEntity> findByName(String name);
    Optional<RestaurantEntity> findByNit(Long nit);


}
