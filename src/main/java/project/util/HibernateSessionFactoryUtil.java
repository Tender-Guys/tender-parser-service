package project.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import project.model.response.Initiator;
import project.model.response.Site;
import project.model.response.Tender;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }

    private static void createSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();

            configuration.addAnnotatedClass(Tender.class)
                         .addAnnotatedClass(Initiator.class)
                         .addAnnotatedClass(Site.class);

            StandardServiceRegistry builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(builder);

        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
