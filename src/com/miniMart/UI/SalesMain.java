/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author srikanthmuppavarapu
 */
public class SalesMain extends JPanel {
    
    JPanel categoryPanel;
    JPanel salesPanel;
    JScrollPane salesListScrollPane;
    JLabel totalLbl;
    
    JList salesItemsList;
    
    public SalesMain(){
        setLayout(new GridLayout(1,3));
    
        categoryPanel = new JPanel(new GridLayout(4,4));
        salesPanel = new JPanel();
        
        salesItemsList = new JList();
        salesItemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        salesListScrollPane = new JScrollPane(salesItemsList); //to hold the sales items
        
        salesPanel.add(salesListScrollPane);
        salesPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        totalLbl = new JLabel("Total  :");
        salesPanel.add(totalLbl);
        
        JPanel separatorPanel = new JPanel();
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        Dimension d = separator.getPreferredSize();
        d.width = 10;
        separatorPanel.setMaximumSize(d);
        
        add(categoryPanel);
        add(separatorPanel);
        add(salesPanel);
        
    }
    
}
