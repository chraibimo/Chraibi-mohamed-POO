package ma.enset.ioc.pres;

import ma.enset.ioc.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier = ctx.getBean("metier", IMetier.class);
        System.out.println("Résultat (Spring XML) = " + metier.calcul());
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
