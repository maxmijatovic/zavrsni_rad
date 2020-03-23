/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.util;

import maxmijatovic.jp21zavrsni.controller.ObradaParticipant;
import maxmijatovic.jp21zavrsni.model.Participant;

/**
 *
 * @author Alice
 */
public class Pomocno {
    
    public static void pocetniInsert(){
        
        Participant participant = new Participant();
        participant.setName("Maksima");
        participant.setSurename("Mijatovic");
        participant.setEmail("maxima.mijatovic@gmail.com");
        
        
        ObradaParticipant obradaParticipant = new ObradaParticipant(participant);
        
        try{
            obradaParticipant.create();
        }catch(EdunovaExeption ex){
            System.out.println(ex.getPoruka());
        }
        
        
        
        
    }
    
}
