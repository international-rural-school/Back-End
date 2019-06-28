package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.Inventory;

import java.util.List;

public interface InventoryService
{
    List<Inventory> findAll();

    Inventory findInventoryById(long id);

    List<Inventory> findByUserName(String username);

    void delete(long id);

    Inventory save(Inventory inventory);
}
