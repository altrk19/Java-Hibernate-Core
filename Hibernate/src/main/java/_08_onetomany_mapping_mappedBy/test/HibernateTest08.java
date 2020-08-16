package _08_onetomany_mapping_mappedBy.test;

import _08_onetomany_mapping_mappedBy.entity.UserEntity8;
import _08_onetomany_mapping_mappedBy.entity.VehicleEntity8;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest08 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity8 user1 = new UserEntity8();
        user1.setUserName("Ali");

        VehicleEntity8 vehicle1 = new VehicleEntity8();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity8 vehicle2 = new VehicleEntity8();
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
        UserEntity8 user = session.get(UserEntity8.class, 1);
        System.out.println(user);
        session.close();
    }

}