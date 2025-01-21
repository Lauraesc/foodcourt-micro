package com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RestaurantResponseSave {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Long nit;
    private String urlLogo;
    private Long ownerId;
}
