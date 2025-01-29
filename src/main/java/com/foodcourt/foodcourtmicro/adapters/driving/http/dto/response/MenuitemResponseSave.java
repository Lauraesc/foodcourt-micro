package com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MenuitemResponseSave {

    private Long id;
    private String name;
    private Long id_category;
    private String description;
    private Integer price;
    private Long id_restaurant;
    private String urlImage;
    private Boolean active;
}
