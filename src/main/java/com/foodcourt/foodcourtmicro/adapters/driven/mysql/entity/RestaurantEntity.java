package com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false, length = 50) //restricciones de varchar en el request también
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "nit", unique = true, nullable = false)
    private Long nit;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
}
