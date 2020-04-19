/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.util;

/**
 *
 * @author Alice
 */
public class BirdCounterException extends Exception {
    
    private String poruka;
    
    public BirdCounterException(String poruka){
        this.poruka=poruka;
    }

   
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }   
    
    public String getPoruka() {
        return poruka;
    }

   
    
    
    
}
