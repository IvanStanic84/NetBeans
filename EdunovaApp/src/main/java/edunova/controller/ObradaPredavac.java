/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Predavac;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author dell
 */
public class ObradaPredavac extends ObradaOsoba<Predavac> {

    @Override
    public List<Predavac> read() {
        return session.createQuery("from Predavac",Predavac.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Predavac";
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        super.kontrolaDelete(); 
        Integer i = session.createNativeQuery(
               "select count(*) from grupa where predavac_sifra=:p", 
               Integer.class).setParameter("p", entitet.getSifra()).getSingleResult();
        if(i>0){
           throw  new EdunovaException("Predavač predaje na jednoj ili više grupa");
       }
    }
    
    
    
}
