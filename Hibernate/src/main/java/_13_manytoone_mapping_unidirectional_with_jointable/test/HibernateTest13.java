package _13_manytoone_mapping_unidirectional_with_jointable.test;

import _13_manytoone_mapping_unidirectional_with_jointable.entity.UserEntity13;
import _13_manytoone_mapping_unidirectional_with_jointable.entity.VehicleEntity13;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest13 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity13 user1 = new UserEntity13();
        user1.setUserName("Ali");

        VehicleEntity13 vehicle1 = new VehicleEntity13();
        vehicle1.setVehicleName("vehicle1");
        vehicle1.setUser(user1);


        VehicleEntity13 vehicle2 = new VehicleEntity13();
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
        UserEntity13 user = session.get(UserEntity13.class, 1);
        System.out.println(user);
        session.close();
    }

}