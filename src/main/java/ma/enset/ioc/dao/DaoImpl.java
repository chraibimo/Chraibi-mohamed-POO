package ma.enset.ioc.dao;

import org.springframework.stereotype.Component;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        double t = 34;
        return t;
    }
}
