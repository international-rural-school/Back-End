package com.lambdaschool.ruralSchools.controllers;
import com.lambdaschool.ruralSchools.models.Inventory;
import com.lambdaschool.ruralSchools.services.InventoryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
    @ApiOperation(value = "Get All Inventory", response = Inventory.class)
    @GetMapping(value = "/inventory",
            produces = {"application/json"})
    public ResponseEntity<?> listAllInventory(
            @PageableDefault(page = 0,
                    size = 5)
                    Pageable pageable) {
        logger.trace("GET /inventory accessed");

        List<Inventory> myInventory = inventoryService.findAll(pageable);
        return new ResponseEntity<>(myInventory, HttpStatus.OK);
    }
    @ApiOperation(value = "Get Inventory By ID", response = Inventory.class)

    @PutMapping(value = "/data/inventory/{inventoryid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateInventory(
            @RequestBody
                    Inventory updateInventory,
            @PathVariable
                    long inventoryid) {
        logger.trace("PUT /data/inventory/" + inventoryid + " was accessed" );

        inventoryService.update(updateInventory, inventoryid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "Assign Condition to Inventory", response = Inventory.class)
    @PostMapping(value = "/data/inventory/{inventoryid}/condition/{conditionid}",
            consumes = {"application/json"})
    public ResponseEntity<?> addConditionToInventory(
            @PathVariable
                    long inventoryid,
            @PathVariable
                    long conditionid) {
        logger.trace("POST /data/inventory/" + inventoryid + "/authors/" + conditionid + " was accessed" );

        inventoryService.updateCondition(inventoryid, conditionid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "Delete Inventory By ID", response = Inventory.class)
    @DeleteMapping(value = "/data/inventory/{id}")
    public ResponseEntity<?> deleteInventoryById(
            @PathVariable
                    long id) {
        logger.trace("DELETE /data/inventory/" + id + " was accessed");

        inventoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}