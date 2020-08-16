package _02_embedded.test;

import _02_embedded.model.AddressEntity2;
import _02_embedded.model.UserEntity2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest02 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity2 user1 = new UserEntity2();
        user1.setUserName("Atakan");

        AddressEntity2 homeAddress = new AddressEntity2();
        homeAddress.setStreet("home street name");
        homeAddress.setState("home state");
        homeAddress.setCity("home city");
        homeAddress.setPostCode("home postcode");
        user1.setHomeAddress(homeAddress);

        AddressEntity2 officeAddress = new AddressEntity2();
        officeAddress.setStreet("office street name");
        officeAddress.setState("office state");
        officeAddress.setCity("office city");
        officeAddress.setPostCode("office postcode");
        user1.setOfficeAddress(officeAddress);


        UserEntity2 user2 = new UserEntity2();
        user2.setUserName("Ali");

        AddressEntity2 homeAddress2 = new AddressEntity2();
        homeAddress2.setStreet("home street 2");
        homeAddress2.setState("home state 2");
        homeAddress2.setCity("home city 2");
        homeAddress2.setPostCode("home postcode 2");
        user2.setHomeAddress(homeAddress2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

    }

    private static void retrieveUser() {
        Session session;
        try{
            session = sessionFactory.openSession();
        } catch (HibernateException ex){
            System.err.println("error occurred");
            return;
        }

        session.beginTransaction();
        UserEntity2 user = session.get(UserEntity2.class, 1);
        UserEntity2 user2 = session.get(UserEntity2.class, 2);

        System.out.println(user);
        System.out.println(user2);
        session.close();
    }

}