/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alice
 */
@Entity
public class BirdCount extends Entitet{
    
    private Date date;
    private String coverage;
    private String quality;
    private String method;
    private String water;
    private String ice;
    private String tidal;
    private String weather;
    private String disturbed;
    
    @ManyToMany
    private List<Species> specieses = new ArrayList<>();
    
    @ManyToOne
    private Site site;
    
    @ManyToOne
    private Participant participant;

    public List<Species> getSpecieses() {
        return specieses;
    }

    public void setSpecieses(List<Species> specieses) {
        this.specieses = specieses;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTidal() {
        return tidal;
    }

    public void setTidal(String tidal) {
        this.tidal = tidal;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDisturbed() {
        return disturbed;
    }

    public void setDisturbed(String disturbed) {
        this.disturbed = disturbed;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    
    
    
    
}
