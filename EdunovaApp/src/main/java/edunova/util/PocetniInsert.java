/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Clan;
import edunova.model.Grupa;
import edunova.model.Polaznik;
import edunova.model.Predavac;
import edunova.model.Smjer;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class PocetniInsert {
    
    private List<Smjer> smjerovi;
    private List<Polaznik> polaznici;
    private List<Predavac> predavaci;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        smjerovi = new ArrayList<>();
        polaznici = new ArrayList<>();
        predavaci = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajSmjerove(10);
        kreirajPolaznike(1000);
        kreirajPredavace(20);
        kreirajGrupe(5);
        sess.getTransaction().commit();
    }

    private void kreirajSmjerove(int broj) {
       for(int i=0;i<broj;i++){
           smjerovi.add(kreirajSmjer());
       }
    }

    private Smjer kreirajSmjer() {
        Smjer s = new Smjer();
        s.setNaziv(faker.book().title());
        sess.persist(s);
        return s;
    }

    private void kreirajPolaznike(int broj) {
        for(int i=0;i<broj;i++){
           polaznici.add(kreirajPolaznika());
       }
    }

    private Polaznik kreirajPolaznika() {
        Polaznik p = new Polaznik();
        p.setIme(faker.address().firstName());
        p.setPrezime(faker.address().lastName());
        sess.persist(p);
        return p;
    }

    private void kreirajPredavace(int broj) {
        for(int i=0;i<broj;i++){
           predavaci.add(kreirajPredavaca());
       }
    }
    
    private Predavac kreirajPredavaca() {
        Predavac p = new Predavac();
        p.setIme(faker.address().firstName());
        p.setPrezime(faker.address().lastName());
        sess.persist(p);
        return p;
    }

    private void kreirajGrupe(int broj) {
        for(int i=0;i<broj;i++){
           kreirajGrupu(i);
       }
    }

    private void kreirajGrupu(int i) {
        Grupa g = new Grupa();
        g.setNaziv(faker.beer().name());
        if(i%2==1){
            g.setSmjer(smjerovi.get(i-1));
        }else{
            g.setSmjer(smjerovi.get(i));
        }
        g.setPredavac(predavaci.get(i));
        sess.persist(g);
        Clan c;
        // ovdje popraviti
        for(int t=i*10;t<(t*10)+10;t++){
            if(t>=polaznici.size()){
                continue;
            }
            c=new Clan();
            c.setGrupa(g);
            c.setPolaznik(polaznici.get(t));
            sess.persist(c);
            g.getClanovi().add(c);
        }
        sess.persist(g);
        
    }
    
    
    
   
    
}
