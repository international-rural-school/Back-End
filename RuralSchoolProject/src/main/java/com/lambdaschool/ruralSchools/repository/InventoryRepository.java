package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Long> {
    @Modifying
    @Query(value = "DELETE FROM inventorycondition WHERE inventoryid = :inventoryid", nativeQuery = true)
    void deleteInventoryAndCondition(long inventoryid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO inventorycondition(inventoryid, conditionid) values (:inventoryid, :conditionid)", nativeQuery = true)
    void insertinventorycondition(long inventoryid, long conditionid);
}
