/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util.loadShows;

import au.bdr.episodefinder.util.Episode;
import au.bdr.episodefinder.util.Show;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brendan
 */
public class MockLoadShowsTest {
    
    public MockLoadShowsTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getShows method, of class MockLoadShows.
     */
    @Test
    public void testGetShows() {
        System.out.println("getShows");
        ALoadShows instance = new MockLoadShows("MockLocation");
        ArrayList<Show> expResult = LoadMockTest();
        ArrayList<Show> result = instance.getShows();
        assertEquals(expResult.size(), result.size());
        //Revenge no episodes
        assertEquals(expResult.get(0).getName(), result.get(0).getName());
        assertEquals(expResult.get(0).getEpisodes(), result.get(0).getEpisodes());
        
        Show expectedShow = expResult.get(1);
        Show resultShow = result.get(1);
        
        assertEquals(expectedShow.getName(), resultShow.getName());
        assertEquals(expectedShow.getEpisodes().size(), resultShow.getEpisodes().size());
        
        
        //Need to make a loop of some description
    }
    
    public ArrayList<Show> LoadMockTest(){
        ArrayList<Show> shows = new ArrayList();
        shows.add(new Show("Revenge"));
        ArrayList<Episode> episodes = new ArrayList();
        int season = 1;
        int episode = 1;
        Date date = new Date(2015, 1, 1);
        int season2 = 2;
        int episode2 = 1;
        Date date2 = new Date(2016, 1, 1);
        episodes.add(new Episode(season, episode, date));
        episodes.add(new Episode(season2, episode2, date2));
        shows.add(new Show("SHIELD", episodes));
        return shows;
    }
    
}
