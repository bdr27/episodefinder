/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Brendan
 */
public class Show {

    private boolean DEBUG = new Debug().getDebug();
    private String name;
    private String url;
    HttpURLConnection connection = null;
    private Document html;
    private ArrayList<Episode> episodes = new ArrayList<Episode>();

    public Show(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Show() {
    }

    /*
     * Connects to the url checks if there is a response and throws IO exception
     * if the wrong response is found
     */
    public void connectUrl(String url) throws IOException {
        URL website = new URL(url);
        connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException();
        }
        html = Jsoup.connect(url).get();
    }

    public void loadHtml() throws IOException {
        html = Jsoup.connect(url).get();
    }

    public void loadEpisodes() throws ParseException {
        Elements tables = html.select("table.wikitable.plainrowheaders");
        int seasonCounter = 1;
        int seasonNumber = 0;
        int airDate = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);

        //Loop through all the tables in the html page
        for (int i = 0; i < tables.size(); i++) {
            boolean containsSeason = false;
            boolean containsEpisode = false;

            //Gets all the table headers for the current table
            Elements tableHeaders = tables.get(i).getElementsByTag("th");

            //Loops through all table headers searching for season and air date to see if it's part of the episodes
            for (int j = 0; j < tableHeaders.size(); j++) {
                String header = tableHeaders.get(j).toString().toLowerCase();

                //Checks if there is season and sets where in the table the season number is
                if (header.contains("season")) {
                    if (DEBUG) {
                        System.out.println("I contain season");
                    }
                    seasonNumber = j - 1;
                    containsSeason = true;
                } //Checks the air date and sets where the air date is in the table
                else if (header.contains("air") && header.contains("date")) {
                    if (DEBUG) {
                        System.out.println("I contain date");
                    }
                    containsEpisode = true;
                    airDate = j - 1;
                }
            }

            //It is a table that contains the required information
            if (containsSeason && containsEpisode) {
                if (DEBUG) {
                    System.out.println("Season Number: " + seasonCounter);
                }
                Elements tableRows = tables.get(i).getElementsByTag("tr");
                System.out.println(tableRows.size());
                for (int k = 1; k < tableRows.size(); k++) {
                    Elements tableData = tableRows.get(k).getElementsByTag("td");
                    if (DEBUG) {
                        System.out.println("Season Location: " + seasonNumber + " Air Date Location: " + airDate);
                    }
                    String episodeNumber = tableData.get(seasonNumber).text();
                    String date = tableData.get(airDate).text();
                    date = date.trim();
                    Date simpleDate = formatter.parse(date);
                    
                    if (DEBUG) {
                        System.out.println("Simple date: " + simpleDate.toString());
                        System.out.println("Season: " + seasonCounter + ", Episode: " + episodeNumber + ", Air Date: " + date);
                    }
                }
                seasonCounter++;
            }
            if (DEBUG) {
                System.out.println("Next...\n");
            }
        }
    }

    public void disconectUrl() {
        connection.disconnect();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Sets the name of the show based on the wikipedia address setting
     */
    public void setNameWithUrl(String url) {
        String address[] = url.split("/");
        String name[] = address[address.length - 1].split("_");
        this.name = name[name.length - 2];
    }
}
