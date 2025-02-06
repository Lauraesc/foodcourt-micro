package com.foodcourt.foodcourtmicro.domain.api;

import com.foodcourt.foodcourtmicro.adapters.driving.http.dto.request.MenuitemRequest;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;

public interface IMenuitemServicePort {

    Menuitem saveMenuitem(Menuitem menuitem, Long id_restaurant);

}
