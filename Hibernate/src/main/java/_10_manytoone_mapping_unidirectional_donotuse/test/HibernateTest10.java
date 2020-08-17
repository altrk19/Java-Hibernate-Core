package _10_manytoone_mapping_unidirectional_donotuse.test;

import _10_manytoone_mapping_unidirectional_donotuse.entity.UserEntity10;
import _10_manytoone_mapping_unidirectional_donotuse.entity.VehicleEntity10;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest10 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity10 user1 = new UserEntity10();
        user1.setUserName("Ali");

        VehicleEntity10 vehicle1 = new VehicleEntity10();
        vehicle1.setVehicleName("vehicle1");
        vehicle1.setUser(user1);


        VehicleEntity10 vehicle2 = new VehicleEntity10();
        vehicle2.setVehicleName("vehicle2");
        vehicle2.setUser(user1);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user1);
        session.save(vehicle1);
        session.save(vehicle2);

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
        UserEntity10 user = session.get(UserEntity10.class, 1);
        System.out.println(user);
        session.close();
    }

}