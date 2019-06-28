package com.lambdaschool.ruralSchools.services;

import com.lambdaschool.ruralSchools.exceptions.ResourceNotFoundException;
import com.lambdaschool.ruralSchools.models.Inventory;
import com.lambdaschool.ruralSchools.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "inventoryService")
public class InventoryServiceImpl implements InventoryService
{
    @Autowired
    private InventoryRepository inventoryrepos;

    @Override
    public List<Inventory> findAll()
    {
        List<Inventory> list = new ArrayList<>();
        inventoryrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Inventory findInventoryById(long id)
    {
        return inventoryrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id)
    {
        if (inventoryrepos.findById(id).isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (inventoryrepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
            {
                inventoryrepos.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(id + " " + authentication.getName());
            }
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Inventory save(Inventory inventory)
    {
        return inventoryrepos.save(inventory);
    }

    @Override
    public List<Inventory> findByUserName(String username)
    {
        List<Inventory> list = new ArrayList<>();
        inventoryrepos.findAll().iterator().forEachRemaining(list::add);

        list.removeIf(q -> !q.getUser().getUsername().equalsIgnoreCase(username));
        return list;
    }
}
