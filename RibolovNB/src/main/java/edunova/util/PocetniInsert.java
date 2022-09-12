package edunova.util;

import edunova.util.HibernateUtil;
import edunovaeclipse.util.Pomocno;
import org.hibernate.Session;

/**
 *
 * @author dell
 */
public class PocetniInsert {

    public static void izvedi() {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();

        s.getTransaction().commit();
    }

}
