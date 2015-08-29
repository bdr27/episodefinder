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
public class MockLoadShows extends ALoadShows {
    public MockLoadShows(String location){
        super(location);
    }

    @Override
    public ArrayList<Show> getShows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
