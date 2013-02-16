/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.main;

import au.bdr.episodefinder.util.Debug;
import au.bdr.episodefinder.GUI.*;
import au.bdr.episodefinder.util.Show;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brendan Russo
 */
public class Main implements ActionListener {

    private MainFrame mainFrame;
    private EnterUrlPanel enterUrl;
    private ShowListPanel showListPanel;
    private final boolean DEBUG = new Debug().getDebug();
    private ArrayList<Show> listOfShows = new ArrayList<Show>();

    public Main() {
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
        switch (e.getActionCommand().toLowerCase()) {
            case "enter":
                String url = enterUrl.getUrl().getText();
                if (DEBUG) {
                    System.out.println(url);
                }
                //Creates an object and checks url
                if (checkUrl(url)) {
                    if (DEBUG) {
                        System.out.println("Success");
                    }
                }
                break;
            default:
                if (DEBUG) {
                    System.out.println("Nothing");
                }
                break;
        }
    }

    public boolean checkUrl(String url) {
        enterUrl.clearText();
        Show show = new Show();
        boolean exists = false;
        try {
            show.connectUrl(url);   
            show = newShow(show, url);
            if(DEBUG){
                show.loadHtml();
                show.loadEpisodes();
            }
            exists = true;            
            listOfShows.add(show);
        } catch (IOException ex) { 
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, url + " is not a valid address");
        } catch (ParseException ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "unknown date conversion error");
        } 
        finally {
            return exists;
        }
    }
    
    public Show newShow(Show show, String url){
        show.disconectUrl();
        show.setUrl(url);
        show.setNameWithUrl(url);
        return show;
    }
}
