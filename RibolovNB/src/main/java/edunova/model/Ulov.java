package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Ulov extends Entitet {
        @ManyToOne
	private Natjecanje natjecanje;
        @ManyToOne
	private Ribic ribic;
        @ManyToOne
	private Riba riba;
	private Integer masa;

	public Ulov(Integer sifra, Natjecanje natjecanje, Ribic ribic, Riba riba, Integer masa) {
		super(sifra);
		this.natjecanje = natjecanje;
		this.ribic = ribic;
		this.riba = riba;
		this.masa = masa;
	}

	public Ulov() {
		super();
	}

	public Natjecanje getNatjecanje() {
		return natjecanje;
	}

	public void setNatjecanje(Natjecanje natjecanje) {
		this.natjecanje = natjecanje;
	}

	public Ribic getRibic() {
		return ribic;
	}

	public void setRibic(Ribic ribic) {
		this.ribic = ribic;
	}

	public Riba getRiba() {
		return riba;
	}

	public void setRiba(Riba riba) {
		this.riba = riba;
	}

	public Integer getMasa() {
		return masa;
	}

	public void setMasa(Integer masa) {
		this.masa = masa;
	}

}
