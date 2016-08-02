/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 17/04/16 @ 16:00
 */

// Menu shown on main screen --- NOT WORKING
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel {
    //public Menu() {
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();   // Create the menu bar.

        menu = new JMenu("Menu");   // Build the menu.
        menuBar.add(menu);
 
        //JMenuItems - Play & Exit
        menuItem = new JMenuItem("Start game");
        menuItem.setMnemonic(KeyEvent.VK_S);
        //menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        //menuItem.addActionListener(this);
        menu.add(menuItem);
 
        return menuBar;
    }
}
