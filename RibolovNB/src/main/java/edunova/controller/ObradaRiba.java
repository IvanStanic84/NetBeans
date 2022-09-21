/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Riba;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRiba extends Obrada<Riba> {

    @Override
    public List<Riba> read() {
        return session.createQuery("from Riba", Riba.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaVrsta();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {

    }

    @Override
    protected void kontrolaDelete() throws RibolovException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "Riba";
    }

    private void kontrolaVrsta() throws RibolovException {
        kontrolaVrstaMoraBitiUnesena();
    }

    private void kontrolaVrstaMoraBitiUnesena() throws RibolovException {
        if (entitet.getVrsta() == null || entitet.getVrsta().trim().isEmpty()) {
            throw new RibolovException("Vrsta ribe mora biti unešena");
        }

    }
}
