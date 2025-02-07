package com.foodcourt.foodcourtmicro.adapters.driving.http.controller;

import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemUpdateRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.MenuitemResponseSave;
import com.foodcourt.foodcourtmicro.adapters.driving.http.mapper.IMenuitemMapperDto;
import com.foodcourt.foodcourtmicro.domain.api.IMenuitemServicePort;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menuitem")
public class MenuitemController {

    private final IMenuitemServicePort menuitemServicePort;
    private final IMenuitemMapperDto menuitemMapperDto;


    @PostMapping("/")
    public ResponseEntity<MenuitemResponseSave> saveMenuitem(@Valid @RequestBody MenuitemRequest menuitemRequest) {

        Menuitem menuitem = menuitemMapperDto.menuitemRequestToMenuitem(menuitemRequest);

        return ResponseEntity.ok(menuitemMapperDto.toMenuitemResponseSave(menuitemServicePort.saveMenuitem(menuitemMapperDto
                .menuitemRequestToMenuitem(menuitemRequest) , menuitemRequest.getId_restaurant())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMenuitem(@PathVariable Long id, @Valid @RequestBody MenuitemUpdateRequest menuitemUpdateRequest) {

        menuitemServicePort.updateMenuitem(id, menuitemUpdateRequest.getDescription(), menuitemUpdateRequest.getPrice());

        return ResponseEntity.ok().build();
    }


}