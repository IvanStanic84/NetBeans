package edunova.model;

import jakarta.persistence.Entity;

@Entity
public class Riba extends Entitet {

    private String vrsta;

    public Riba(Integer sifra, String vrsta) {
        super(sifra);
        this.vrsta = vrsta;
    }

    public Riba() {
        super();
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String toString() {
        return vrsta;
    }

}
