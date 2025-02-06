package com.foodcourt.foodcourtmicro.domain.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Menuitem {

    private Long id;
    private String name;
    private Long id_category;
    private String description;
    private Integer price;
    private Restaurant restaurant;
    private String urlImage;
    private boolean active;
}
