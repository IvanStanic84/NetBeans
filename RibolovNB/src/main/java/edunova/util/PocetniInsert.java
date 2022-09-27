package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Natjecanje;
import edunova.model.Operater;
import edunova.model.Riba;
import edunova.model.Ribic;
import edunova.model.Riboloviste;
import edunova.model.Ribolovnodrustvo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author dell
 */
public class PocetniInsert {

    private List<Riba> ribe;
    private List<Ribic> ribici;
    private List<Ribolovnodrustvo> ribolovnadrustva;
    private List<Riboloviste> ribolovista;
    private List<Natjecanje> natjecanja;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        ribe = new ArrayList<>();
        ribici = new ArrayList<>();
        ribolovnadrustva = new ArrayList<>();
        ribolovista = new ArrayList<>();
        natjecanja = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajRibe(10);
        kreirajRibice(10);
        kreirajRibolovnadrustva(0);
        kreirajRibolovista(5);
        //kreirajNatjecanja(5);
        kreirajOperatera();
        sess.getTransaction().commit();
    }

    private void kreirajRibolovnadrustva(int broj) {
        for (int i = 0; i < broj; i++) {
            ribolovnadrustva.add(kreirajRibolovnodrustvo());
        }
    }

    private Ribolovnodrustvo kreirajRibolovnodrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme(faker.book().title());
        rd.setMjesto(faker.book().title());
        rd.setOib("70515566734");
        rd.setIban(faker.book().title());
        sess.persist(rd);
        return rd;
    }

    private void kreirajRibe(int broj) {
        for (int i = 0; i < broj; i++) {
            ribe.add(kreirajRibu());
        }
    }

    private Riba kreirajRibu() {
        Riba rb = new Riba();
        rb.setVrsta(faker.address().firstName());
        sess.persist(rb);
        return rb;
    }

    private void kreirajRibolovista(int broj) {
        for (int i = 0; i < broj; i++) {
            ribolovista.add(kreirajRiboloviste());
        }
    }

    private Riboloviste kreirajRiboloviste() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv(faker.address().firstName());
        rl.setVrstavode(faker.address().lastName());

        sess.persist(rl);
        return rl;
    }

    private void kreirajRibice(int broj)  {
        for (int i = 0; i < broj; i++) {
            kreirajRibica(i);
        }
    }

    private void kreirajRibica(int i) {
        Ribic rc = new Ribic();
        rc.setIme(faker.beer().name());
        rc.setPrezime(faker.beer().name());
        rc.setOib(Pomocno.getOib());
        /*
        if (i % 2 == 1) {
            rc.setRibolovnodrustvo(ribolovnadrustva.get(i-1));
        } else {
            rc.setRibolovnodrustvo(ribolovnadrustva.get(i));
        }
*/
     //   rc.setRibolovnodrustvo(ribolovnodrustvo);
        sess.persist(rc);

    }
   /* private void kreirajNatjecanja(int broj) {
        for (int i = 0; i < broj; i++) {
            kreirajNatjecanje(i);
        }
    }

    /*private void kreirajNatjecanje(int i) {
        Natjecanje n = new Natjecanje();
        n.setVrsta(faker.beer().name());
        //n.setPocetak(faker.beer().name());
        //n.setKraj(Pomocno.getOib());
        /*if (i % 2 == 1) {
            rc.setRibolovnodrustvo(ribolovnadrustva.get(i));
        } else {
            rc.setRibolovnodrustvo(ribolovnadrustva.get(i+1));
        }

        sess.persist(rc);

    }
*/

    private void kreirajOperatera() {
        Operater o = new Operater();
        o.setIme("Ivan");
        o.setPrezime("Stanić");
        o.setOib("70515566734");
        o.setLozinka(BCrypt.hashpw("stamba", BCrypt.gensalt()));
        sess.persist(o);
    }

}
