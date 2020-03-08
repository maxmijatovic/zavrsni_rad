/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Alice
 */
@MappedSuperclass
public abstract class Species extends Entitet {
    
    @Column(name = "scientific_name_genus")
    private String scientificNameGenus;
    
    @Column(name = "scientific_name_species")
    private String scientificNameSpecies;
    
    @Column(name = "english_name")
    private String englishName;
    
    @Column(name = "species_group")
    private String speciesGroup;
    
    @Column(name = "species_code")
    private String speciesCode;

    public String getScientificNameGenus() {
        return scientificNameGenus;
    }

    public void setScientificNameGenus(String scientificNameGenus) {
        this.scientificNameGenus = scientificNameGenus;
    }

    public String getScientificNameSpecies() {
        return scientificNameSpecies;
    }

    public void setScientificNameSpecies(String scientificNameSpecies) {
        this.scientificNameSpecies = scientificNameSpecies;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getSpeciesGroup() {
        return speciesGroup;
    }

    public void setSpeciesGroup(String speciesGroup) {
        this.speciesGroup = speciesGroup;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }
    
    
    
}
