/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.Dao;

import com.miniMart.model.Item;
import com.miniMartPOS.hibernate.HibernateUtil;
import org.hibernate.HibernateException;

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
    
}
