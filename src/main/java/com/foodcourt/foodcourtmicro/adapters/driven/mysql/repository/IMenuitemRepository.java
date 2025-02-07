package com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.MenuitemEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IMenuitemRepository extends JpaRepository<MenuitemEntity, Long> {

    Optional<MenuitemEntity> findByName(String name);
}
