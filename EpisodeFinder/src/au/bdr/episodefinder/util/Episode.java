/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.bdr.episodefinder.util;

import java.util.Date;

/**
 *
 * @author Brendan Russo
 */
public class Episode {
    private int season;
    private int episode;
    private Date airDate;
    
    public Episode(int season, int episode, Date airDate){
        this.season = season;
        this.episode = episode;
        this.airDate = airDate;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }
}
