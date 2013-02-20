/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.main;

import au.bdr.episodefinder.util.Show;
import au.bdr.episodefinder.util.Shows;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brendan Russo
 */
public class MainCLI {

    private static final String menu = "Please select one of the following "
            + "options\n\t1. Add New Show\n\t2. View Current Shows \n\t3. See"
            + " what's coming up this week\n\tQ to quit\nChoice: ";
    private static final Scanner keyboard = new Scanner(System.in);
    private static final boolean DEBUG = true;
    private static Shows shows = new Shows();

    public static void main(String[] args) {
        if(!shows.loadShows()){
            System.out.println("Failed to load text");
        }
        
        System.out.println("Welcome to Brendan Russo's command line episode finder");
        System.out.print(menu);        
        String choice = keyboard.nextLine();
        while(!choice.toLowerCase().equals("q")){
            switch(choice.toLowerCase()){
                case "1":
                    addShow();
                    break;
                case "2":
                    viewCurrentShows();
                    break;
                case "3":
                    thisWeek();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("\n\tIncorrect menu option!!!!\n");
            }
            System.out.print(menu);
            choice = keyboard.nextLine();
        }
    }
    private static void addShow(){
        boolean addedShow = false;
        Show show = new Show();
        System.out.print("Please enter the url of the episode list\nurl: ");
        String url = keyboard.nextLine();
        if(show.setShow(url)){
            if(shows.addShow(show)){
                addedShow = true;
            }
        }
        if(addedShow){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
    }
    
    private static void viewCurrentShows(){
        System.out.println("view current shows is not currently implemented");
    }
    
    private static void thisWeek(){
        System.out.println("what's coming up this week is not currently implemented");
    }
}
