package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._6_onetomany_mapping_bidirectional_with_fetch.test;

import _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._6_onetomany_mapping_bidirectional_with_fetch.entity.UserEntity15;
import _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._6_onetomany_mapping_bidirectional_with_fetch.entity.VehicleEntity15;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest15 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity15 user1 = new UserEntity15();
        user1.setUserName("Ali");

        VehicleEntity15 vehicle1 = new VehicleEntity15();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity15 vehicle2 = new VehicleEntity15();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);
        vehicle1.setUser(user1);
        vehicle2.setUser(user1);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user1);
//      session.save(vehicle1);
//      session.save(vehicle2);

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
        UserEntity15 user = session.get(UserEntity15.class, 1);
        System.out.println(user);
        session.close();
    }

}
