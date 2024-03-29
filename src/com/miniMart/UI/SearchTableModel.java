package com.miniMart.UI;

import com.miniMart.Dao.ItemDaoImpl;
import com.miniMart.model.Item;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SearchTableModel extends AbstractTableModel {
        
        private boolean DEBUG = false;
        ItemDaoImpl itemDao = new ItemDaoImpl();
        private String[] columnNames = {"Barcode",
                                        "Product Name",
                                        "Price",
                                        "GST",
                                        "Category"};
        
        private Object[][] data = setData();
       
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
        
        
        
        
        private Object[][] setData(){
            List<Item> results = itemDao.getAllItems();
            Object[][] objResults = new Object[results.size()][5];
            
            for(int i=0; i < results.size(); i++){
                
                Item it = results.get(i);
                
                objResults[i][0] = it.getBarcode();
                objResults[i][1] = it.getName();
                objResults[i][2] = it.getPrice();
                objResults[i][3] = it.getGst();
                objResults[i][4] = it.getCategory();
                
            }
            
            return objResults;
        } 

        
    }