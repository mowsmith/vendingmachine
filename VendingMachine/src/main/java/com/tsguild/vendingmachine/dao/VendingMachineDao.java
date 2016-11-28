/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.InventoryItem;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Morgan Smith
 */
public interface VendingMachineDao {

    // create
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    InventoryItem addInventoryItem(InventoryItem item);

    // read
    List<InventoryItem> getAllInventoryItems();
    InventoryItem getInventoryItemById(int itemId);

    // delete
    void removeInventoryItem(int itemId);

    // update
    void updateInventoryItem(InventoryItem item);
    
}
