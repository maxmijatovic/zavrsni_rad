/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;


import java.util.List;
import maxmijatovic.jp21zavrsni.model.Participant;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alice
 */
public class ObradaParticipant extends Obrada<Participant> {

    public ObradaParticipant() {
        super();
    }

    public ObradaParticipant(Participant entitet) {
        super(entitet);
    }
    
    public Participant autoriziraj(String email, String lozinka){
        
        List<Participant> lista = session.createQuery("from Participant p "
                + " where p.email=:email")
                .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Participant p = lista.get(0);
        if(p==null){
            return null;
        }
        return BCrypt.checkpw(lozinka, p.getLozinka()) ? p : null;
    }
    
    

    @Override
    protected void kontrolaCreate() throws BirdCounterException {
       kontrolaEmail();
       kontrolaLozinka();
      
       
    }

    @Override
    protected void kontrolaUpdate() throws BirdCounterException{
        
    }

    @Override
    protected void kontrolaDelete() throws BirdCounterException {
        
    }
   
   
    @Override
    public List<Participant> getPodaci() {
        return session.createQuery("from Participant").list();
    }

    @Override
    protected void nakonSpremanja()  {
        
    }
    
    protected void kontrolaEmail()  throws BirdCounterException {
        
         Long ukupno = (Long) session
                .createQuery(" select count(p) from Participant p "
                + " where p.email=:email")
                .setParameter("email", entitet.getEmail())
                .uniqueResult();
        
        if(ukupno>0) {
            throw new BirdCounterException("The Email already exists");
        }
       
    }
    
    private void kontrolaLozinka() throws BirdCounterException {
        if(entitet.getLozinka()==null || BCrypt.checkpw("", entitet.getLozinka())){
            throw new BirdCounterException("Password Required");
        }
    } 
    
   
        
    
}
