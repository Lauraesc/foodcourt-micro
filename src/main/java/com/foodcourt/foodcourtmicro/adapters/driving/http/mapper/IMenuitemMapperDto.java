package com.foodcourt.foodcourtmicro.adapters.driving.http.mapper;


import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.MenuitemResponseSave;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMenuitemMapperDto {


    Menuitem menuitemRequestToMenuitem(MenuitemRequest menuitemRequest);
    @Mapping(source = "restaurant.id", target = "id_restaurant")
    MenuitemResponseSave toMenuitemResponseSave(Menuitem menuitem);
}
