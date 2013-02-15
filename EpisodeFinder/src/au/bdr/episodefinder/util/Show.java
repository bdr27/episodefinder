/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.bdr.episodefinder.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brendan
 */
public class Show {

    private boolean DEBUG = new Debug().getDebug();
    private String name;
    private String url;
    HttpURLConnection connection = null;

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
        url = url.replaceFirst("https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
        URL website = new URL(url);
        connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException();
        }
        InputStream is = website.openStream();  // throws an IOException
        DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
        String line;
        while ((line = dis.readLine()) != null) {
            System.out.println(line);
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
