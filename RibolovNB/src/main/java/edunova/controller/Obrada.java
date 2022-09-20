/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;

    public Obrada() {
        this.session=HibernateUtil.getSession();
        
        
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
}
