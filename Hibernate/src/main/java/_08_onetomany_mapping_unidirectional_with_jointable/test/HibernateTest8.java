package _08_onetomany_mapping_unidirectional_with_jointable.test;

import _08_onetomany_mapping_unidirectional_with_jointable.entity.UserEntity8;
import _08_onetomany_mapping_unidirectional_with_jointable.entity.VehicleEntity8;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest8 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity8 user1 = new UserEntity8();
        user1.setUserName("İbrahim");

        VehicleEntity8 vehicle1 = new VehicleEntity8();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity8 vehicle2 = new VehicleEntity8();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);

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