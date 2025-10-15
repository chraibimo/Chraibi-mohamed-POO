package ma.enset.ioc.presentation;
import ma.enset.ioc.ext.DaoImplV2;
import ma.enset.ioc.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
//        DaoImpl d = new DaoImpl();
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); // Injcetion des dépendances
        System.out.println("RES = "+metier.calcul());
    }
}
