/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class Show {
    private String url = "";
    private String name = "";
    
    public Show() {
    }
    
    public Show(String url, String name){
        this.url = url;
        this.name = name;
    }

    /*
     * Sets the url and the show name checks that the page can be reached and
     * if the site is wikipdedia
     */
    public boolean setShow(String url){
        boolean success = false;
        if(checkUrl(url)){
            if(url.contains("wikipedia")){
                //Splits the url to get the name of show
                String splitUrl[] = url.split("/");
                String splitName[] = splitUrl[splitUrl.length-1].split("_");
                this.url = url;
                this.name = splitName[2];
                success = true;
            }
        }
        return success;
    }
    
    /*
     * Checks that the url can be reached
     */
    private boolean checkUrl(String url) {
        HttpURLConnection connection = null;
        try{
            URL website = new URL(url);
            connection = (HttpURLConnection) website.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();        
            if(responseCode != 200){
            
            }
            connection.disconnect();
        }catch(Exception ex){
            ex.toString();
            return false;
        }
        return true;
    }
    public String getUrl(){
        return url;
    }
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "name: " + name + " url: " + url;
    }
}
// OLD SHOW
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
///**
// *
// * @author Brendan
// */
//public class Show {
//
//    private boolean DEBUG = new Debug().getDebug();
//    private String name;
//    private String url;
//    HttpURLConnection connection = null;
//    private Document html;
//
//    public Show(String name, String url) {
//        this.name = name;
//        this.url = url;
//    }
//
//    public Show() {
//    }
//
//    /*
//     * Connects to the url checks if there is a response and throws IO exception
//     * if the wrong response is found
//     */
//    public void connectUrl(String url) throws IOException {
//        URL website = new URL(url);
//        connection = (HttpURLConnection) website.openConnection();
//        connection.setRequestMethod("HEAD");
//        int responseCode = connection.getResponseCode();
//        if (responseCode != 200) {
//            throw new IOException();
//        }
//        html = Jsoup.connect(url).get();
//    }
//
//    public void loadHtml() throws IOException {
//        html = Jsoup.connect(url).get();
//    }
//
//    public void loadEpisodes() throws ParseException {
//        Elements tables = html.select("table.wikitable.plainrowheaders");
//        int seasonCounter = 1;
//        int seasonNumber = 0;
//        int airDate = 0;
//        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
//
//        //Loop through all the tables in the html page
//        for (int i = 0; i < tables.size(); i++) {
//            boolean containsSeason = false;
//            boolean containsEpisode = false;
//
//            //Gets all the table headers for the current table
//            Elements tableHeaders = tables.get(i).getElementsByTag("th");
//
//            //Loops through all table headers searching for season and air date to see if it's part of the episodes
//            for (int j = 0; j < tableHeaders.size(); j++) {
//                String header = tableHeaders.get(j).toString().toLowerCase();
//
//                //Checks if there is season and sets where in the table the season number is
//                if (header.contains("season")) {
//                    if (DEBUG) {
//                        System.out.println("I contain season");
//                    }
//                    seasonNumber = j - 1;
//                    containsSeason = true;
//                } //Checks the air date and sets where the air date is in the table
//                else if (header.contains("air") && header.contains("date")) {
//                    if (DEBUG) {
//                        System.out.println("I contain date");
//                    }
//                    containsEpisode = true;
//                    airDate = j - 1;
//                }
//            }
//
//            //It is a table that contains the required information
//            if (containsSeason && containsEpisode) {
//                if (DEBUG) {
//                    System.out.println("Season Number: " + seasonCounter);
//                }
//                Elements tableRows = tables.get(i).getElementsByTag("tr");
//                System.out.println(tableRows.size());
//                for (int k = 1; k < tableRows.size(); k++) {
//                    Elements tableData = tableRows.get(k).getElementsByTag("td");
//                    if (DEBUG) {
//                        System.out.println("Season Location: " + seasonNumber + " Air Date Location: " + airDate);
//                    }
//                    String episodeNumber = tableData.get(seasonNumber).text();
//                    String date = tableData.get(airDate).text();
//                    int index = date.length();
//                    if (date.contains("(")) {
//                        System.out.println("I am here");
//                        index = date.indexOf((int) '(') - 1;
//                    }
//                    date = date.substring(0, index);
//                    Date simpleDate = formatter.parse(date);
//
//                    if (DEBUG) {
//                        System.out.println(simpleDate);
//                        //System.out.println(space);
//                       // System.out.println("day: " + day + " month: " + month + " year: " + year);
//                        System.out.println("Season: " + seasonCounter + ", Episode: " + episodeNumber + ", Air Date: " + date);
//                    }
//                }
//                seasonCounter++;
//            }
//            if (DEBUG) {
//                System.out.println("Next...\n");
//            }
//        }
//    }
//
//    public void disconectUrl() {
//        connection.disconnect();
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /*
//     * Sets the name of the show based on the wikipedia address setting
//     */
//    public void setNameWithUrl(String url) {
//        String address[] = url.split("/");
//        String name[] = address[address.length - 1].split("_");
//        this.name = name[name.length - 2];
//    }
//
//    public int getMonth(String month) {
//        int mon = 0;
//        month = month.toLowerCase();
//
//        if (month.contains("jan")) {
//            mon = 1;
//        } else if (month.contains("feb")) {
//            mon = 2;
//        } else if (month.contains("mar")) {
//            mon = 3;
//        } else if (month.contains("apr")) {
//            mon = 4;
//        } else if (month.contains("may")) {
//            mon = 5;
//        } else if (month.contains("jun")) {
//            mon = 6;
//        } else if (month.contains("jul")) {
//            mon = 7;
//        } else if (month.contains("aug")) {
//            mon = 8;
//        } else if (month.contains("sep")) {
//            mon = 9;
//        } else if (month.contains("oct")) {
//            mon = 10;
//        } else if (month.contains("nov")) {
//            mon = 11;
//        } else if (month.contains("dec")) {
//            mon = 12;
//        }
//        return mon;
//    }
//}
