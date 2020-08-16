package _07_onetomany_mapping.test;

import _07_onetomany_mapping.entity.UserEntity7;
import _07_onetomany_mapping.entity.VehicleEntity7;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest07 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity7 user1 = new UserEntity7();
        user1.setUserName("Ali");

        VehicleEntity7 vehicle1 = new VehicleEntity7();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity7 vehicle2 = new VehicleEntity7();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);

        //ManyToOne
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
        UserEntity7 user = session.get(UserEntity7.class, 1);
        System.out.println(user);
        session.close();
    }

}