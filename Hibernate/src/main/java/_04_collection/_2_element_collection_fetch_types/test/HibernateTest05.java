package _04_collection._2_element_collection_fetch_types.test;

import _04_collection._2_element_collection_fetch_types.entity.AddressEntity5;
import _04_collection._2_element_collection_fetch_types.entity.UserEntity5Eager;
import _04_collection._2_element_collection_fetch_types.entity.UserEntity5Lazy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest05 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUserLazy();
        insertUserEager();
    }

    private static void insertUserLazy() {
        UserEntity5Lazy user = new UserEntity5Lazy();
        user.setUserName("Ali");

        AddressEntity5 addr1 = new AddressEntity5();
        addr1.setStreet("Street 1");
        addr1.setCity("City 1");
        addr1.setPostCode("postcode 1");

        user.getListOfAddresses().add(addr1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        //we are getting the user object without the addresses
        user = session.get(UserEntity5Lazy.class, 1);
        session.close();

        System.out.println("user name : " + user.getUserName());




        //the following line fails beacuse of lazy initialization.
        //System.out.println(user.getListOfAddresses());


    }

    private static void insertUserEager() {
        UserEntity5Eager user = new UserEntity5Eager();
        user.setUserName("Umut");

        AddressEntity5 addr1 = new AddressEntity5();
        addr1.setStreet("Street 3");
        addr1.setCity("City 3");
        addr1.setPostCode("postcode 3");

        user.getListOfAddresses().add(addr1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        //we are getting the user object without the addresses
        user = session.get(UserEntity5Eager.class, 1);
        System.out.println(user);
        session.close();

        System.out.println("user name : " + user.getUserName());



        //now it is eager initialization
        System.out.println(user.getListOfAddresses());


    }

}