/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.util;

import maxmijatovic.jp21zavrsni.controller.ObradaParticipant;
import maxmijatovic.jp21zavrsni.model.Participant;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alice
 */
public class Pomocno {
    
    public static Participant LOGIRAN;
    
    public static String getNazivAplikacije(){
        return "Bird Counter APP";
    }
    
    
    
    public static void pocetniInsert(){
        
        
        Participant p = new Participant();
        p.setEmail("maxima.mijatovic@gmail.com");
        p.setName("Maksima");
        p.setSurename("Mijatovic");
        p.setLozinka(BCrypt.hashpw("123", BCrypt.gensalt()));
        
        
        
        ObradaParticipant obradaParticipant = new ObradaParticipant(p);
        try {
            obradaParticipant.create();
        } catch (EdunovaExeption ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        Participant participant = new Participant();
        participant.setName("Maksima");
        participant.setSurename("Mijatovic");
        participant.setEmail("maxima.mijatovic@gmail.com");
        
        
        
        
        try{
            obradaParticipant.create();
        }catch(EdunovaExeption ex){
            System.out.println(ex.getPoruka());
        }
        
        Participant participant2 = new Participant();
        participant2.setName("Adrian");
        participant2.setSurename("Tomik");
        participant2.setEmail("adrian.tomik@gmail.com");
        
        obradaParticipant = new ObradaParticipant(participant2);
        
        try{
            obradaParticipant.create();
        }catch(EdunovaExeption ex){
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        
        
        
        
    }
    
}
