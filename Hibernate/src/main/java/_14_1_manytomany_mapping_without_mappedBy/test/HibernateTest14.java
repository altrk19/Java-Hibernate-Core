package _14_1_manytomany_mapping_without_mappedBy.test;

import _14_1_manytomany_mapping_without_mappedBy.entity.UserEntity14;
import _14_1_manytomany_mapping_without_mappedBy.entity.VehicleEntity14;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest14 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity14 user1 = new UserEntity14();
        user1.setUserName("Ali");

        VehicleEntity14 vehicle1 = new VehicleEntity14();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity14 vehicle2 = new VehicleEntity14();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);

        vehicle1.getUserList().add(user1);
        vehicle2.getUserList().add(user1);

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
        UserEntity14 user = session.get(UserEntity14.class, 1);
        System.out.println(user);
        session.close();
    }

}