package com.foodcourt.foodcourtmicro.adapters.driving.http.mapper;

import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.RestaurantRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.RestaurantResponseSave;
import com.foodcourt.foodcourtmicro.domain.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)

public interface IRestaurantMapperDto {

    Restaurant restaurantRequestToRestaurant(RestaurantRequest userRequest);
    RestaurantResponseSave toRestaurantResponseSave(Restaurant restaurant);


}
