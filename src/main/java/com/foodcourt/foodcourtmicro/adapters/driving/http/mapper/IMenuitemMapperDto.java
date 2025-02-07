package com.foodcourt.foodcourtmicro.adapters.driving.http.mapper;


import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemUpdateRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.MenuitemResponseSave;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMenuitemMapperDto {


    Menuitem menuitemRequestToMenuitem(MenuitemRequest menuitemRequest);
    @Mapping(source = "restaurant.id", target = "id_restaurant")
    MenuitemResponseSave toMenuitemResponseSave(Menuitem menuitem);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "id_category", ignore = true)
    @Mapping(target = "restaurant", ignore = true)
    @Mapping(target = "urlImage", ignore = true)
    @Mapping(target = "active", ignore = true)
    Menuitem menuitemUpdateRequestToMenuitem(MenuitemUpdateRequest menuitemUpdateRequest);
}
