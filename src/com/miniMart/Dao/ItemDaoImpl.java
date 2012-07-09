/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.Dao;

import com.miniMart.model.Item;
import com.miniMartPOS.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author srikanthmuppavarapu
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public void saveItem(Item it) {
        try{
            Session session = HibernateUtil.beginTransaction();
            session.saveOrUpdate(it);
            HibernateUtil.commitTransaction();
        }
        catch(HibernateException he){
            he.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
    }
    
    @Override
    public List<Item> getAllItems(){
        
        try {
            Session session = HibernateUtil.beginTransaction();
            Query query = session.createQuery("from Item");
            List results = query.list();
            HibernateUtil.commitTransaction();
            
            if(results.size() > 0 )
                return results;
            else 
                return null;
            
        }
        catch(HibernateException he){
            he.printStackTrace();
        }
        
        return null;
    }
    
}
