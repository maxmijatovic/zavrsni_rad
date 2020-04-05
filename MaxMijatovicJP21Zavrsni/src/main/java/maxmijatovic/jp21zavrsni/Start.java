/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni;

import maxmijatovic.jp21zavrsni.util.HibernateUtil;
import maxmijatovic.jp21zavrsni.util.Pomocno;
import maxmijatovic.jp21zavrsni.view.SplashScreen;

/**
 *
 * @author Alice
 */
public class Start {
    
    public Start(){
        
        //HibernateUtil.getSessionFactory().openSession();
        
        //Pomocno.pocetniInsert();
        
        new SplashScreen().setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
}


