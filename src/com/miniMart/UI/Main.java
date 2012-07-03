/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniMart.UI;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author srikanthmuppavarapu
 */
public class Main {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                MainFrame mainFrame = new MainFrame();
                mainFrame.initComponents();
                mainFrame.setVisible(true);
            }
        });

    }
}
