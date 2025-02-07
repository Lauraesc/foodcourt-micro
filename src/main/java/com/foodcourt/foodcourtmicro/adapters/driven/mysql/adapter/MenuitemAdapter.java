package com.foodcourt.foodcourtmicro.adapters.driven.mysql.adapter;

import com.foodcourt.foodcourtmicro.adapters.driven.mysql.entity.MenuitemEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.mapper.IMenuitemMapperEntity;
import com.foodcourt.foodcourtmicro.adapters.driven.mysql.repository.IMenuitemRepository;
import com.foodcourt.foodcourtmicro.domain.model.Menuitem;
import com.foodcourt.foodcourtmicro.domain.spi.IMenuitemPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
@RequiredArgsConstructor
public class MenuitemAdapter implements IMenuitemPersistencePort {
    private final IMenuitemRepository menuitemRepository;
    private final IMenuitemMapperEntity menuitemMapperEntity;

    @Override
    public Menuitem saveMenuitem(Menuitem menuitem) {
        return menuitemMapperEntity.menuitemEntityToMenuitem(
                menuitemRepository.save(
                        menuitemMapperEntity.menuitemToMenuitemEntity(menuitem)
                )
        );
    }

    @Override
    public Optional<Menuitem> findByName(String name) {
        return menuitemRepository.findByName(name)
                .map(menuitemMapperEntity::menuitemEntityToMenuitem);
    }

    @Override
    public Optional<Menuitem> findById(Long id) {
        return menuitemRepository.findById(id)
                .map(menuitemMapperEntity::menuitemEntityToMenuitem);
    }

    @Override
    public Menuitem updateMenuitem(Menuitem menuitem) {

        return menuitemMapperEntity.menuitemEntityToMenuitem(
                menuitemRepository.save(
                        menuitemMapperEntity.menuitemToMenuitemEntity(menuitem)
                )
        );

    }


}
