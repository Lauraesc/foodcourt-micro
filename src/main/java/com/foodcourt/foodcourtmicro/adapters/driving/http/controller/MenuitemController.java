package com.foodcourt.foodcourtmicro.adapters.driving.http.controller;

import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.MenuitemResponseSave;
import com.foodcourt.foodcourtmicro.adapters.driving.http.mapper.IMenuitemMapperDto;
import com.foodcourt.foodcourtmicro.domain.api.IMenuitemServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menuitem")
public class MenuitemController {

    private final IMenuitemServicePort menuitemServicePort;
    private final IMenuitemMapperDto menuitemMapperDto;


    @PostMapping("/")
    public ResponseEntity<MenuitemResponseSave> saveMenuitem(@Valid @RequestBody MenuitemRequest userRequest) {

        return ResponseEntity.ok(menuitemMapperDto.toMenuitemResponseSave(menuitemServicePort.saveMenuitem(menuitemMapperDto
                .menuitemRequestToMenuitem(userRequest) )));
    }
}