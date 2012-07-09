/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.miniMart.UI.SearchTableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author srikanthmuppavarapu
 */
public class EditInventory extends JPanel{
    
    JTable searchTable;
    JTextField filterTxt;
    private final JTextField filterText;
    private TableRowSorter sorter;
    
    
    public EditInventory(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        SearchTableModel model = new SearchTableModel();
         sorter = new TableRowSorter<SearchTableModel>(model);
        searchTable = new JTable(model);
        searchTable.setFillsViewportHeight(true); 
        searchTable.setRowSorter(sorter);
        
        searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(searchTable);
        add(scrollPane); 
        
        JPanel form = new JPanel();
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField(40);
        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
        l1.setLabelFor(filterText);
        form.add(filterText);
        SpringUtilities.makeCompactGrid(form, 1, 1, 6,6, 6, 6);
        add(form);
        
    }
    
    /** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() {
        RowFilter<SearchTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 1);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
}
