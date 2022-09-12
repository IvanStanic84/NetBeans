package edunova.model;

import jakarta.persistence.Entity;

@Entity
public class Ribolovnodrustvo extends Entitet {

	private String ime;
	private String mjesto;
	private String oib;
	private String iban;

	public Ribolovnodrustvo(Integer sifra, String ime, String mjesto, String oib, String iban) {
		super(sifra);
		this.ime = ime;
		this.mjesto = mjesto;
		this.oib = oib;
		this.iban = iban;
	}

	public Ribolovnodrustvo() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
