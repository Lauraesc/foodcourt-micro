package com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuitemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "id_category", nullable = false)
    private Long id_category;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "url_image", nullable = false)
    private String urlImage;
    @Column(name = "active", nullable = false)
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private RestaurantEntity restaurantEntity;


}
