package ma.enset.ioc.pres;

import ma.enset.ioc.dao.DaoImpl;
import ma.enset.ioc.metier.MetierImpl;

public class PresStatic {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();          // couplage fort (démo)
        MetierImpl metier = new MetierImpl(); // couplage faible via setter
        metier.setDao(dao);

        System.out.println("Résultat (statique) = " + metier.calcul());
    }
}
