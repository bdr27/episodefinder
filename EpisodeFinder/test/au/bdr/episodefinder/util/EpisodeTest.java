/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brendan
 */
public class EpisodeTest {
    
    public EpisodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSeason method, of class Episode.
     */
    @Test
    public void testGetSeason() {
        System.out.println("getSeason");
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        int expResult = 1;
        int result = instance.getSeason();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeason method, of class Episode.
     */
    @Test
    public void testSetSeason() {
        System.out.println("setSeason");
        int season = 65;
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        instance.setSeason(season);
        assertEquals(season, instance.getSeason());
    }

    /**
     * Test of getEpisode method, of class Episode.
     */
    @Test
    public void testGetEpisode() {
        System.out.println("getEpisode");
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        int expResult = 5;
        int result = instance.getEpisode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEpisode method, of class Episode.
     */
    @Test
    public void testSetEpisode() {
        System.out.println("setEpisode");
        int episode = 55;
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        instance.setEpisode(episode);
        assertEquals(55, instance.getEpisode());
    }

    /**
     * Test of getAirDate method, of class Episode.
     */
    @Test
    public void testGetAirDate() {
        System.out.println("getAirDate");        
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        Date expResult = date;
        Date result = instance.getAirDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAirDate method, of class Episode.
     */
    @Test
    public void testSetAirDate() {
        System.out.println("setAirDate");
        Date date = new Date(2015, 1, 28);
        Episode instance = new Episode(1, 5, date);
        Date airDate = new Date(2010, 3, 23);        
        instance.setAirDate(airDate);
        assertEquals(airDate, instance.getAirDate());
    }
    
}
