package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long>
{

}
