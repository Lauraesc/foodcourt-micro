package com.foodcourt.foodcourtmicro.adapters.driving.http.controller;

import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.RestaurantRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.RestaurantResponseSave;
import com.foodcourt.foodcourtmicro.adapters.driving.http.mapper.IRestaurantMapperDto;
import com.foodcourt.foodcourtmicro.domain.api.IRestaurantServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantMapperDto restaurantMapperDto;


    @PostMapping("/")
    public ResponseEntity<RestaurantResponseSave> saveRestaurantAdmin(@Valid @RequestBody RestaurantRequest userRequest) {
        return ResponseEntity.ok(restaurantMapperDto.toRestaurantResponseSave(restaurantServicePort.saveRestaurant(restaurantMapperDto
                .restaurantRequestToRestaurant(userRequest) )));
    }
}
