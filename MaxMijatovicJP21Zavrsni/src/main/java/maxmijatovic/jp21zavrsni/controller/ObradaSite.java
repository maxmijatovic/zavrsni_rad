/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;

import java.util.List;
import maxmijatovic.jp21zavrsni.model.Site;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;


/**
 *
 * @author Alice
 */
public class ObradaSite extends Obrada<Site> {

    public ObradaSite() {
    }

    public ObradaSite(Site entitet) {
        super(entitet);
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
    public List<Site> getPodaci() {
        return session.createQuery("from Site").list();
        
    }

    @Override
    protected void nakonSpremanja() throws BirdCounterException {
        
    }
    
}
