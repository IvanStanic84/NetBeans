package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Polaznik extends Osoba {

	private String brojUgovora;
	
        @OneToMany(mappedBy = "polaznik")
        private List<Clan> clanovi;
	

	public Polaznik() {
		super();
	}
	

	public Polaznik(Integer sifra, String ime, String prezime, String oib, String email, String brojUgovora) {
		super(sifra, ime, prezime, oib, email);
		this.brojUgovora = brojUgovora;
	}







	public String getBrojUgovora() {
		return brojUgovora;
	}

	public void setBrojUgovora(String brojUgovora) {
		this.brojUgovora = brojUgovora;
	}

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }
	
        
        
}
