package com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper;


import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.MenuitemEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.RestaurantEntity;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMenuitemMapperEntity {

    @Mapping(source = "restaurant", target = "restaurantEntity")
    MenuitemEntity menuitemToMenuitemEntity(Menuitem menuitem);

    @Mapping(source = "restaurantEntity", target = "restaurant")
    Menuitem menuitemEntityToMenuitem(MenuitemEntity menuitemEntity);

}
