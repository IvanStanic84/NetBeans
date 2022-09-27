/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Operater;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Korisnik
 */
public class ObradaOperater extends ObradaRibic {

    public Operater autoriziraj(String Oib, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater where Oib=:Oib",
                    Operater.class)
                    .setParameter("Oib", Oib)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(new String(lozinka), o.getLozinka())){
            Operater vrati = new Operater();
            vrati.setSifra(o.getSifra());
            vrati.setIme(o.getIme());
            vrati.setPrezime(o.getPrezime());
            vrati.setOib(o.getOib());
            // ne postavljamo lozinku da ne bude u memoriji
            return vrati;     
        }
        
        return null;
    }

    @Override
    public List read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Operater";
    }
}