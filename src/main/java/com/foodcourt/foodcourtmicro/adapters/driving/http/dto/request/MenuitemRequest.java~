package com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuitemRequest {


    @NotBlank(message = "El nombre del plato es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre del plato debe tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚüÜ\\s]+$", message = "Solo se permiten letras, números y espacios.")
    private String name;
    @NotNull(message = "La categoría es obligatoria")
    @Positive(message = "La categoría debe ser un número positivo.")
    private Long id_category;
    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 1000, message = "La descripción debe tener entre 10 y 1000 caracteres.")
    private String description;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0.")
    private Integer price;
    @NotBlank(message = "La url de la imagen es obligatoria")
    private String urlImage;
    @NotNull(message = "El estado es obligatorio")
    private boolean active;

}
