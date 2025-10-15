package ma.enset.ioc.metier;

import ma.enset.ioc.dao.DaoImpl;
import ma.enset.ioc.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MetierImpl implements IMetier {
    private IDao dao; // Couplage faible

    @Autowired
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double d = dao.getData();
        double res= d*18;
        return res;
    }

    /*
    Pour Injecter dans la variable dao
    un objet d'une classe qui implémente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}