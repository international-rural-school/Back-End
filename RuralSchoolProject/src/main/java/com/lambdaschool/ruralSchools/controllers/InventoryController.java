package com.lambdaschool.ruralSchools.controllers;

import com.lambdaschool.ruralSchools.models.Inventory;
import com.lambdaschool.ruralSchools.services.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    InventoryService inventoryService;

    @GetMapping(value = "/inventories",
                produces = {"application/json"})
    public ResponseEntity<?> listAllInventories(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Inventory> allInventories = inventoryService.findAll();
        return new ResponseEntity<>(allInventories, HttpStatus.OK);
    }


    @GetMapping(value = "/inventory/{inventoryId}",
                produces = {"application/json"})
    public ResponseEntity<?> getInventory(HttpServletRequest request,
                                      @PathVariable
                                              Long inventoryId)
    {
        logger.trace(request.getRequestURI() + " accessed");

        Inventory q = inventoryService.findInventoryById(inventoryId);
        return new ResponseEntity<>(q, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> findInventoryByUserName(HttpServletRequest request,
                                                 @PathVariable
                                                         String userName)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Inventory> theInventories = inventoryService.findByUserName(userName);
        return new ResponseEntity<>(theInventories, HttpStatus.OK);
    }


    @PostMapping(value = "/inventory")
    public ResponseEntity<?> addNewInventory(HttpServletRequest request, @Valid
    @RequestBody
            Inventory newInventory) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        newInventory = inventoryService.save(newInventory);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newInventoryURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{inventoryid}").buildAndExpand(newInventory.getInventoriesid()).toUri();
        responseHeaders.setLocation(newInventoryURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<?> deleteInventoryById(HttpServletRequest request,
                                             @PathVariable
                                                     long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        inventoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
