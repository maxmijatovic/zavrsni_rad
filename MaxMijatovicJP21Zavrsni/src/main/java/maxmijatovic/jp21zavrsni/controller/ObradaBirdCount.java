/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;

import java.util.List;
import maxmijatovic.jp21zavrsni.model.BirdCount;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;


/**
 *
 * @author Alice
 */
public class ObradaBirdCount extends Obrada<BirdCount>{

    public ObradaBirdCount() {
    }

    public ObradaBirdCount(BirdCount entitet) {
        super(entitet);
    }

    @Override
    public BirdCount create() throws BirdCounterException {
       kontrolaCreate();
       save();
       nakonSpremanja();
       return entitet;
    }

    @Override
    public BirdCount update() throws BirdCounterException {
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
     private void save() {
        session.beginTransaction();
        session.save(entitet);
        entitet.getCounters().forEach((c)-> {
            session.save(c);
        });
        session.getTransaction().commit();
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
    public List<BirdCount> getPodaci() {
       return session.createQuery("from BirdCount").list();
    }

    @Override
    protected void nakonSpremanja() throws BirdCounterException {
        
    }

   
    
}
