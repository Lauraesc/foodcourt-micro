package com.foodcourt.foodcourtmicro.adapters.driving.http.mapper;


import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.response.MenuitemResponseSave;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMenuitemMapperDto {


    Menuitem menuitemRequestToMenuitem(MenuitemRequest userRequest);
    MenuitemResponseSave toMenuitemResponseSave(Menuitem menuitem);
}
