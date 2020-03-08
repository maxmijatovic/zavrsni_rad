/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alice
 */
@Entity
public class SpeciesBirdCount extends Entitet {
    
    @ManyToOne
    private Species species;
    
    @ManyToOne
    @Column(name = "bird_count")
    private BirdCount birdCount;
    
    @Column(name = "number_of_birds")
    private Integer numberOfBirds;
    
}
