package com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    Optional<RestaurantEntity> findByName(String name);
    Optional<RestaurantEntity> findByNit(Long nit);

}
