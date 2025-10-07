package ma.enset.ioc.pres;

import ma.enset.ioc.dao.IDao;
import ma.enset.ioc.metier.IMetier;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class PresDynamic {
    public static void main(String[] args) throws Exception {
        // Charger depuis le classpath (src/main/resources)
        Properties props = new Properties();
        try (InputStream in = PresDynamic.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in == null) throw new RuntimeException("config.properties introuvable");
            props.load(in);
        }

        String daoClassName = props.getProperty("dao.class");
        String metierClassName = props.getProperty("metier.class");

        Class<?> cDao = Class.forName(daoClassName);
        Class<?> cMetier = Class.forName(metierClassName);

        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        Method setDao = cMetier.getMethod("setDao", IDao.class);
        setDao.invoke(metier, dao);

        System.out.println("Résultat (dynamique) = " + metier.calcul());
    }
}
