/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.main;

import au.bdr.episodefinder.GUI.EnterUrl;
import au.bdr.episodefinder.GUI.MainFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Brendan Russo
 */
public class Main implements ActionListener {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        EnterUrl enterUrl = new EnterUrl();
        mainFrame.add(enterUrl, BorderLayout.NORTH);
        mainFrame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Something happened");
    }
}
