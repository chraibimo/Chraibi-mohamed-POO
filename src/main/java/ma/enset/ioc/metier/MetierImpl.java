package ma.enset.ioc.metier;

import ma.enset.ioc.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    private IDao dao;

    public MetierImpl() {}

    @Autowired
    public MetierImpl(IDao dao) { // injection par constructeur
        this.dao = dao;
    }

    public void setDao(IDao dao) { // injection par setter
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData() * 5;
    }
}
