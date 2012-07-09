/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.Dao;

import com.miniMart.model.Item;
import java.util.List;

/**
 *
 * @author srikanthmuppavarapu
 */
public interface ItemDao {
    
    public void saveItem(Item it);
    
    public List<Item> getAllItems();
    
}
