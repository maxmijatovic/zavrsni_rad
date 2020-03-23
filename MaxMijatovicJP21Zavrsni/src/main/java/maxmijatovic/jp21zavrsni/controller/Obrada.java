/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmijatovic.jp21zavrsni.controller;


import java.util.List;
import maxmijatovic.jp21zavrsni.util.EdunovaExeption;
import maxmijatovic.jp21zavrsni.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Alice

 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws EdunovaExeption;
    protected abstract void kontrolaUpdate() throws EdunovaExeption;
    protected abstract void kontrolaDelete() throws EdunovaExeption;
    public abstract List<T> getPodaci();
    protected abstract void nakonSpremanja() throws EdunovaExeption;
   
   
    
    public Obrada() {
    
    session = HibernateUtil.getSessionFactory().openSession();
    
    }
  
    public Obrada (T entitet) {
        this();
        this.entitet = entitet;
    }
    
    
    
    public T create() throws EdunovaExeption {
        
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
        
    }
    
    public T update() throws EdunovaExeption {
        
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
        
    }
    
    public boolean delete() throws EdunovaExeption {
        
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
