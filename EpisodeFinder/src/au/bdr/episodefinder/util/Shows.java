/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brendan Russo
 */
public class Shows {

    private ArrayList<Show> shows = new ArrayList<Show>();
    private String filename = "src/resources/listOfShows.txt";

    public Shows() {
    }

    public boolean loadShows() {
        boolean success = false;
        File fileInput = new File(filename);
        try {
            Scanner fin = new Scanner(fileInput);
            while (fin.hasNextLine()) {
                String[] line = fin.nextLine().split(",,,");
                String name = line[0];
                String url = line[1];
                Show show = new Show(url, name);
                shows.add(show);
            }
            fin.close();
            success = true;
        } catch (FileNotFoundException ex) {
            ex.toString();
        }
        return success;
    }

    public boolean updateShows() {
        boolean success = false;
        try {
            //Creates a new Print Writer
            PrintWriter fout = new PrintWriter(filename);
            //Loops through all array scores and prints to file
            for (Show show : shows) {
                fout.printf("%s,,,%s%n", show.getName(),
                        show.getUrl());
            }
            fout.close();
            success = true;
        } catch (FileNotFoundException ex) {
            ex.toString();
        }
        return success;
    }

    public boolean addShow(Show show) {
        boolean success = false;;
        if (!shows.contains(show)) {
            System.out.println("I get there");
            shows.add(show);
            if (!updateShows()) {
                shows.remove(show);
                System.out.println("Failed to update shows");
            }else{
                success = true;
            }
        } 
        return success;
    }
}
