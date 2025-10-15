package ma.enset.ioc.ext;

import ma.enset.ioc.dao.IDao;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("d2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version web service");
        double d = 20;
        return d;
    }
}
