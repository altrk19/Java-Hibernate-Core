package _12_onetomany_mapping_bidirectional_mappedBy.test;

import _12_onetomany_mapping_bidirectional_mappedBy.entity.UserEntity12;
import _12_onetomany_mapping_bidirectional_mappedBy.entity.VehicleEntity12;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest12 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity12 user1 = new UserEntity12();
        user1.setUserName("Ali");

        VehicleEntity12 vehicle1 = new VehicleEntity12();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity12 vehicle2 = new VehicleEntity12();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);
        vehicle1.setUser(user1);
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
        UserEntity12 user = session.get(UserEntity12.class, 1);
        System.out.println(user);
        session.close();
    }

}