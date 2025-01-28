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
    @NotBlank(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0.")
    private Integer price;
    @NotNull(message = "La descripción es obligatoria")
    @Size(min = 10, max = 1000, message = "La descripción debe tener entre 10 y 1000 caracteres.")
    private String description;
    @NotBlank(message = "La url de la imagen es obligatoria")
    private String urlImage;
    @NotBlank(message = "La categoría es obligatoria")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$", message = "La categoría solo puede contener letras y espacios.")
    @Size(min = 3, max = 50, message = "La categoría debe tener entre 3 y 50 caracteres.")
    private String category;

    //hay algo de active, no sé
}
