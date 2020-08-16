package _01_insert_retrieve.test;

import _01_insert_retrieve.model.UserEntity1;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class HibernateTest01 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static final String DESC =
            "Ut nec diam ut sem condimentum tincidunt. Phasellus fermentum venenatis dolor, eu vestibulum urna condimentum id. Nullam tellus dolor, tristique eget massa tincidunt, posuere ornare enim. Nam fringilla, risus et sodales fermentum, nisi mauris interdum lectus, nec sollicitudin enim diam vitae metus. Donec mattis facilisis felis a efficitur. Vivamus molestie ipsum ex, vitae finibus sapien dictum scelerisque. Nulla a eros ac quam malesuada sodales.";

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity1 user = new UserEntity1();
        user.setUserName("Ali");
        user.setAddress("Istanbul Tukey");
        user.setDescription(DESC);
        user.setJoinedDate(Date.valueOf("2020-08-15"));

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);


        UserEntity1 user2 = new UserEntity1();
        user2.setUserName("Umut");
        session.save(user2);

        session.getTransaction().commit();
        session.close();

    }

    private static void retrieveUser() {
        Session session;
        try{
             session = sessionFactory.openSession();
        } catch (HibernateException ex){
            System.err.println("error occurred");
            return;
        }

        session.beginTransaction();
        UserEntity1 user = session.get(UserEntity1.class, 1);

        System.out.println(user);
        session.close();
    }
}

