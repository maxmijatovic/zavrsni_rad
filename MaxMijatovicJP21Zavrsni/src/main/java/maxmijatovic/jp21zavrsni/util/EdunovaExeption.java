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
public class EdunovaExeption extends Exception {
    
    private String poruka;

    public EdunovaExeption(String message) {
        super(message);
    }

   
    
    
    

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    
    
}
