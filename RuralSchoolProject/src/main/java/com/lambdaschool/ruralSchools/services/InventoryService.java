package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.Inventory;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryService
{
    List<Inventory> findAll(Pageable pageable);

    Inventory findInventoryById(long id);

    void delete(long id);

    void updateCondition(long inventoryid, long conditionid);

    Inventory update(Inventory inventory, long id);
}
