package com.foodcourt.foodcourtmicro.domain.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Menuitem {

    private String name;
    private Integer price;
    private String description;
    private String urlImage;
    private String category;

}
