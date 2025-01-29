package com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper;


import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.MenuitemEntity;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IMenuitemMapperEntity {

    Menuitem menuitemEntityToMenuitem(MenuitemEntity menuitemEntity);
    MenuitemEntity menuitemToMenuitemEntity(Menuitem menuitem);
}
