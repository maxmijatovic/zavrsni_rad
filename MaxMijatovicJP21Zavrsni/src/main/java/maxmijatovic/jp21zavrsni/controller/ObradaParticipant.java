/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;


import java.util.List;
import maxmijatovic.jp21zavrsni.model.Participant;
import maxmijatovic.jp21zavrsni.util.EdunovaExeption;

/**
 *
 * @author Alice
 */
public class ObradaParticipant extends Obrada<Participant> {

    public ObradaParticipant() {
    }

    public ObradaParticipant(Participant entitet) {
        super(entitet);
    }
    
   

    @Override
    protected void kontrolaCreate() throws EdunovaExeption {
       
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaExeption{
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaExeption {
        
    }
   
   
    @Override
    public List<Participant> getPodaci() {
        return session.createQuery("from Participant").list();
    }

    @Override
    protected void nakonSpremanja()  {
        
    }
        
    
}
