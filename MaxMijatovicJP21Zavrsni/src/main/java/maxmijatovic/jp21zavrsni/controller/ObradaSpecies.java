/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;

import java.util.List;
import maxmijatovic.jp21zavrsni.model.Species;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;


/**
 *
 * @author Alice
 */
public class ObradaSpecies extends Obrada<Species>{
    
    public ObradaSpecies(Species species){
        super(species);
    }
    
    public ObradaSpecies() {
        super();
    }

    @Override
    protected void kontrolaCreate() throws BirdCounterException {
        
    }

    @Override
    protected void kontrolaUpdate() throws BirdCounterException {
        
    }

    @Override
    protected void kontrolaDelete() throws BirdCounterException {
        
    }

    @Override
    public List<Species> getPodaci() {
       return session.createQuery("from Species").list();
    }
    
    public List<Species> getPodaci(String uvjet){
        return session.createQuery("from Species s "
                + " where concat(s.englishName) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(25).list();
    }

    @Override
    protected void nakonSpremanja() throws BirdCounterException {
        
    }
    
}
