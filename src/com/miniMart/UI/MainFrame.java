/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author srikanthmuppavarapu
 */
public class MainFrame extends JFrame{
    
    public void initComponents(){
        setTitle("MINI MART POS");
        setLayout(new GridLayout(1,1));
        setPreferredSize(new Dimension(700, 650));
        
       
        JTabbedPane mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setTabPlacement(JTabbedPane.TOP);
       
        //Inventory pannel initialization
        JPanel inventoryPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        AddInventory addInventoryPanel = new AddInventory();
        addInventoryPanel.setVisible(true);
        
        
        JButton addInventoryButton = new JButton("Add Inventory");
        JButton editInventoryButton = new JButton("Edit Inventory");
        JButton deleteInventoryButton = new JButton("Delete Inventory");
        
        buttonPanel.add(addInventoryButton);
        buttonPanel.add(editInventoryButton);
        buttonPanel.add(deleteInventoryButton);
        
        inventoryPanel.add(buttonPanel, BorderLayout.NORTH);
        inventoryPanel.add(addInventoryPanel, BorderLayout.CENTER);

        ImageIcon invIcon = new ImageIcon(getClass().getResource("/images/inventory.jpeg"));
        
        
        
        Image img = invIcon.getImage();
        Image scaledImg = img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon invIcon1  = new ImageIcon(scaledImg);
        
        System.out.println(" Image Icon details : " + invIcon1.getIconHeight() + "   " + invIcon1.getIconWidth());
        
        
        //second tab
        JPanel dummyPanel1 = new JPanel(new BorderLayout());
        JPanel dummyPanel2 = new JPanel();
        dummyPanel1.add(dummyPanel2, BorderLayout.CENTER);
        
        
        mainTabbedPane.addTab("Inventory",invIcon1, inventoryPanel, "Inventory Mgt functions");
        mainTabbedPane.addTab("Sales",null,dummyPanel1,"Sales Mgt functions");
        
        add(mainTabbedPane);
        pack();
    }
    
    
}
