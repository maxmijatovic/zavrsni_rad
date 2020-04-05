/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;


import java.util.List;
import maxmijatovic.jp21zavrsni.util.BirdCounterException;
import maxmijatovic.jp21zavrsni.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Alice

 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws BirdCounterException;
    protected abstract void kontrolaUpdate() throws BirdCounterException;
    protected abstract void kontrolaDelete() throws BirdCounterException;
    public abstract List<T> getPodaci();
    protected abstract void nakonSpremanja() throws BirdCounterException;
   
   
    
    public Obrada() {
    
    session = HibernateUtil.getSessionFactory().openSession();
    
    }
  
    public Obrada (T entitet) {
        this();
        this.entitet = entitet;
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
    
    public T create() throws BirdCounterException {
        
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
        
    }
    
     public void createAll(List<T> lista) throws BirdCounterException{
    
        session.beginTransaction();
        for(T sl : lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
        
        
    }
    
    public T update() throws BirdCounterException {
        
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
        
    }
    
    public boolean delete() throws BirdCounterException {
        
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
        
    }
    
    private void save() {
        
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        
    }
    
    
}
