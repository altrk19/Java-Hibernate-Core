package _11_manytoone_mapping_unidirectional_avoiding_with_joincolumn.test;

import _11_manytoone_mapping_unidirectional_avoiding_with_joincolumn.entity.UserEntity11;
import _11_manytoone_mapping_unidirectional_avoiding_with_joincolumn.entity.VehicleEntity11;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest11 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity11 user1 = new UserEntity11();
        user1.setUserName("Ali");

        VehicleEntity11 vehicle1 = new VehicleEntity11();
        vehicle1.setVehicleName("vehicle1");
        vehicle1.setUser(user1);


        VehicleEntity11 vehicle2 = new VehicleEntity11();
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
        UserEntity11 user = session.get(UserEntity11.class, 1);
        System.out.println(user);
        session.close();
    }

}