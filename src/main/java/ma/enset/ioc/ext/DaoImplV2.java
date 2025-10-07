package ma.enset.ioc.ext;

import ma.enset.ioc.dao.IDao;
import org.springframework.stereotype.Component;

@Component("daoV2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        return 55.0;
    }
}
