/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
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
    
    public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
     public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df().format(b);
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df().parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
           
    }
    
    private static DecimalFormat df(){
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    }
    
    
    
    public static void pocetniInsert(){
        
        
        Participant p = new Participant();
        p.setEmail("maxima.mijatovic@gmail.com");
        p.setName("Maksima");
        p.setSurname("Mijatović");
        p.setLozinka(BCrypt.hashpw("123", BCrypt.gensalt()));
        
        
        
        ObradaParticipant obradaParticipant = new ObradaParticipant(p);
        try {
            obradaParticipant.create();
        } catch (BirdCounterException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        Participant participant = new Participant();
        participant.setName("Maksima");
        participant.setSurname("Mijatović");
        participant.setEmail("maxima.mijatovic@gmail.com");
        
        
        
        
        try{
            obradaParticipant.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        Participant participant2 = new Participant();
        participant2.setName("Ivana");
        participant2.setSurname("Grgić");
        participant2.setEmail("ivana.grgic@gmail.com");
        
        obradaParticipant = new ObradaParticipant(participant2);
        
        try{
            obradaParticipant.create();
        }catch(BirdCounterException ex){
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        
        
        
        
    }
    
}
