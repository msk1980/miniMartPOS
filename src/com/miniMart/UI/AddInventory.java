/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.UI;

import com.miniMart.Dao.ItemDao;
import com.miniMart.Dao.ItemDaoImpl;
import com.miniMart.model.Item;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author srikanthmuppavarapu
 */
public class AddInventory extends JPanel {
    
      ItemDao itemDao = new ItemDaoImpl();
      
      JTextField nameTxt;
      JTextField barcodeTxt;
      JTextField quantityTxt;
      JTextField priceTxt;
      JTextField gstTxt;
      JTextField gstPercentageTxt;
      JTextField cartonQtyTxt;
      JTextField categoryTxt;
      
    public AddInventory(){
        setLayout(new GridLayout(10,2));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel nameLabel = new JLabel("Name   :");
        JLabel barcodeLabel = new JLabel("Barcode : ");
        JLabel quantityLabel = new JLabel("Quantity :");
        JLabel priceLabel = new JLabel("Price : ");
        JLabel gstLabel = new JLabel("GST :");
        JLabel gstPercentLabel = new JLabel("Gst Percentage : ");
        JLabel cartonQtyLabel = new JLabel("Carton Quantity :");
        JLabel categoryLabel = new JLabel("Category : ");
        
        nameTxt = new JTextField();
        barcodeTxt = new JTextField();
        quantityTxt = new JTextField();
        priceTxt = new JTextField();
        gstTxt = new JTextField();
        gstPercentageTxt = new JTextField();
        cartonQtyTxt = new JTextField();
        categoryTxt = new JTextField();
        
        JButton addBtn = new JButton("Add");
        JButton clearBtn = new JButton("Clear");
        
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Item item = new Item();
                
                item.setName(nameTxt.getText());
                item.setBarcode(barcodeTxt.getText());
                item.setQuantity(new Integer( quantityTxt.getText()));
                item.setPrice(new Float(priceTxt.getText()));
                item.setGst(new Float(gstTxt.getText()));
                item.setGstPercent(new Float(gstPercentageTxt.getText()));
                item.setCartonQty(new Integer(cartonQtyTxt.getText()));
                item.setCategory(categoryTxt.getText());
                
                itemDao.saveItem(item);
                JOptionPane.showMessageDialog(null, "Item saved successfully.");
            }
        });
        
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                nameTxt.setText("");
                barcodeTxt.setText("");
                quantityTxt.setText("");
                priceTxt.setText("");
                gstTxt.setText("");
                gstPercentageTxt.setText("");
                cartonQtyTxt.setText("");
                categoryTxt.setText("");
            }
        });
        
        
        add(nameLabel);
        add(nameTxt);
        add(barcodeLabel);
        add(barcodeTxt);
        add(quantityLabel);
        add(quantityTxt);
        add(priceLabel);
        add(priceTxt);
        add(gstLabel);
        add(gstTxt);
        add(gstPercentLabel);
        add(gstPercentageTxt);
        add(cartonQtyLabel);
        add(cartonQtyTxt);
        add(categoryLabel);
        add(categoryTxt);
        
        add(addBtn);
        add(clearBtn);
    }
    
   
}
