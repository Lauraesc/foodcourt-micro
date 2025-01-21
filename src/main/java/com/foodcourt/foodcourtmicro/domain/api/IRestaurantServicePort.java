package com.foodcourt.foodcourtmicro.domain.api;

import com.foodcourt.foodcourtmicro.domain.model.Restaurant;

public interface IRestaurantServicePort {

    Restaurant saveRestaurant(Restaurant restaurant);
}
