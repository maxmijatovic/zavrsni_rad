/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import maxmijatovic.jp21zavrsni.util.Pomocno;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;

/**
 *
 * @author Alice
 */
@Entity
@Table(name = "counter")
public class Counter extends Entitet{
    
    
    @ManyToOne
    private Species species;
    
    @ManyToOne
    private BirdCount birdCount;
    
      
    
    private Integer numberOfBirds;
    
    

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public BirdCount getBirdCount() {
        return birdCount;
    }

    public void setBirdCount(BirdCount birdCount) {
        this.birdCount = birdCount;
    }

    public Integer getNumberOfBirds() {
        return numberOfBirds;
    }

    public void setNumberOfBirds(Integer numberOfBirds) {
        this.numberOfBirds = numberOfBirds;
    }

    @Override
    public String toString() {
        return getSpecies().getEnglishName() +  " >>> " + "Counted: " + getNumberOfBirds();
    }
    
    
    
    
    

    
    
    
    
}
