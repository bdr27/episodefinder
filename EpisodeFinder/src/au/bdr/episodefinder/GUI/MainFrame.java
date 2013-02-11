/*
 * Main GUI of the program
 */

package au.bdr.episodefinder.GUI;

import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author Brendan Russo
 */
public class MainFrame extends JFrame{
    
    public MainFrame(){
        this.setVisible(true);
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
