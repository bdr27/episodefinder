/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.main;

import au.bdr.episodefinder.GUI.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Brendan Russo
 */
public class Main implements ActionListener {
    private MainFrame mainFrame;
    private EnterUrlPanel enterUrl;
    private ShowListPanel showListPanel;
    private final boolean DEBUG = new Debug().getDebug();
    
    public Main(){
        mainFrame = new MainFrame();
        enterUrl = new EnterUrlPanel();
        showListPanel = new ShowListPanel();
        enterUrl.getConfirm().addActionListener(this);
        mainFrame.add(enterUrl, BorderLayout.NORTH);
        mainFrame.add(showListPanel, BorderLayout.CENTER);
        mainFrame.pack();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand().toLowerCase()){
            case "enter":
                if(DEBUG){
                    System.out.println(enterUrl.getUrl().getText());
                }
                break;
            default:
                if(DEBUG){
                    System.out.println("Nothing");
                }
                break;
        }
    }
}
