package com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "El nombre debe estar tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9\\s]+$", message = "El nombre solo puede contener letras y números")
    private String name;
    private String address;
    @NotBlank(message = "El número de teléfono es obligatorio")
    @Size( max = 13, message = "El número de teléfono debe tener máximo 13 caracteres")
    @Pattern(regexp = "^[+]?[0-9]{1,13}$", message = "El número debe empazar en + y contener solo números (de 1 a 13)")
    private String phone;
    @NotNull(message = "El NIT es obligatorio")
    private Long nit;
    private String urlLogo;
    @NotNull(message = "El id del dueño es obligatorio")
    private Long ownerId;
}
