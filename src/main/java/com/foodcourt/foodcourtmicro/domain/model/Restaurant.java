package com.foodcourt.foodcourtmicro.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Restaurant {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Long nit;
    private String urlLogo;
    private Long ownerId;
}
