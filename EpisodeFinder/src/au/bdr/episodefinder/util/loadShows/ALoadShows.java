/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util.loadShows;

import au.bdr.episodefinder.util.Show;
import java.util.ArrayList;

/**
 *
 * @author Brendan
 */
public abstract class ALoadShows {
    ArrayList<Show> shows;
    String location;
    
    public ALoadShows(String location){
        this.location = location;
        shows = new ArrayList();
    }
    
    public abstract ArrayList<Show> getShows();
}
