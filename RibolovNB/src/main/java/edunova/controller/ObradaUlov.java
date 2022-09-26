/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Ulov;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaUlov extends Obrada<Ulov> {

    @Override
    public List<Ulov> read() {
        return session.createQuery("from Ulov", Ulov.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaMasa();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {

    }

    @Override
    protected void kontrolaDelete() throws RibolovException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "Ulov";
    }

    private void kontrolaMasa() throws RibolovException {
        kontrolaMasaUGramima();
        kontrolaMasaUnesena();
    }

    private void kontrolaMasaUGramima() throws RibolovException {
        //   if (entitet.getMasa() = ???????) {
        //      throw new RibolovException("Masa mora biti unešena");
        //  }

    }

    private void kontrolaMasaUnesena() throws RibolovException {
        if (entitet.getMasa() == null) {
            throw new RibolovException("Masa mora biti unešena");
        }
    }
}
