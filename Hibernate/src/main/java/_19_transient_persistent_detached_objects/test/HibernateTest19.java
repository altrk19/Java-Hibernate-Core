package _19_transient_persistent_detached_objects.test;

import _19_transient_persistent_detached_objects.entity.UserEntity19;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest19 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        UserEntity19 user1 = new UserEntity19();
        user1.setUserName("name");


        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(user1);

        user1.setUserName("updated Name");

        session.getTransaction().commit();
        session.close();

        user1.setUserName("detached object");
    }
}
