/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util.loadShows;

import au.bdr.episodefinder.util.Show;
import java.util.ArrayList;
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
        MockLoadShows instance = null;
        ArrayList<Show> expResult = null;
        ArrayList<Show> result = instance.getShows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
