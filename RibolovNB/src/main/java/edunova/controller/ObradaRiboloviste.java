/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;


import edunova.model.Riboloviste;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRiboloviste extends Obrada<Riboloviste> {

    @Override
    public List<Riboloviste> read() {
        return session.createQuery("from Riboloviste", Riboloviste.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaNaziv();
        kontrolaVrstaVode();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
    }

    @Override
    protected String getNazivEntiteta() {
        return "Riboloviste";
    }

    private void kontrolaNaziv() throws RibolovException {
        kontrolaNazivMoraBitiUnesen();
    }

    private void kontrolaVrstaVode() throws RibolovException {
        kontrolaVrstaVodeMoraBitiUnesena();
    }

    private void kontrolaNazivMoraBitiUnesen() throws RibolovException {
        if (entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()) {
            throw new RibolovException("Naziv ribolovišta mora biti unešen");
        }

    }

    private void kontrolaVrstaVodeMoraBitiUnesena() throws RibolovException {
        if (entitet.getVrstavode() == null || entitet.getVrstavode().trim().isEmpty()) {
            throw new RibolovException("Vrsta vode mora biti unešena");
        }

    }
}
