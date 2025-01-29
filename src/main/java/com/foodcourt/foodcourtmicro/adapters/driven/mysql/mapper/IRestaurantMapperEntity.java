package com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper;


import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.RestaurantEntity;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapperEntity {

    Restaurant restaurantEntityToRestaurant(RestaurantEntity restaurantEntity);
    RestaurantEntity restaurantToRestaurantEntity(Restaurant restaurant);

}
