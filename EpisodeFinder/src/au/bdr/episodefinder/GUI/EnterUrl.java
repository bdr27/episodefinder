/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.bdr.episodefinder.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Brendan Russo
 */
public class EnterUrl extends JPanel{
    private JTextField url = new JTextField();
    private JButton confirm = new JButton("Enter");
    
    /*
     * Creates the JPanel with a label and a button
     */
    public EnterUrl(){
        this.setLayout(new FlowLayout());
        url.setColumns(40);
        this.add(url);
        this.add(confirm);
        this.setFocusable(true);
    }    
    
    public JButton getConfirm(){
        return confirm;
    }
}
