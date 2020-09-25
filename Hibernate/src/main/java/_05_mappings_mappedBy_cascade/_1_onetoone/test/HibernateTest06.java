package _05_mappings_mappedBy_cascade._1_onetoone.test;

import _05_mappings_mappedBy_cascade._1_onetoone.entity.UserEntity6;
import _05_mappings_mappedBy_cascade._1_onetoone.entity.VehicleEntity6;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest06 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity6 user1 = new UserEntity6();
        user1.setUserName("Ali");

        VehicleEntity6 vehicle1 = new VehicleEntity6();
        vehicle1.setVehicleName("vehicle name 1");
        user1.setVehicle(vehicle1);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user1);
        session.save(vehicle1);

        session.getTransaction().commit();
        session.close();
    }

    private static void retrieveUser() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            System.err.println("error occurred");
            return;
        }

        session.beginTransaction();
        UserEntity6 user = session.get(UserEntity6.class, 1);
        System.out.println(user);
        session.close();
    }

}