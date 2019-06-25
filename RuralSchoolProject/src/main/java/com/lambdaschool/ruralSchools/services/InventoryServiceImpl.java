package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.models.Inventory;
import com.lambdaschool.ruralSchools.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "inventoryService")
public class InventoryServiceImpl implements InventoryService
{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findAll(Pageable pageable) {
        List<Inventory> list = new ArrayList<>();
        inventoryRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Inventory findInventoryById(long id) throws EntityNotFoundException
    {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException{
        if (inventoryRepository.findById(id).isPresent()) {
            inventoryRepository.deleteInventoryAndCondition(id);
            inventoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public void updateCondition(long inventoryid, long conditionid) {
        inventoryRepository.insertinventorycondition(inventoryid, conditionid);
    }

    @Override
    public Inventory update(Inventory inventory, long id)
    {
        Inventory currentInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (inventory.getInventoryitem() != null)
        {
            currentInventory.setInventoryitem(inventory.getInventoryitem());
        }
        if (inventory.getCopy() != null) {
            currentInventory.setCopy(inventory.getCopy());
        }
        if (inventory.getIsbn() != null) {
            currentInventory.setIsbn(inventory.getIsbn());
        }

        return inventoryRepository.save(currentInventory);
    }
}
