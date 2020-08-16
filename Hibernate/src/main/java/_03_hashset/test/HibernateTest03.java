package _03_hashset.test;

import _03_hashset.entity.AddressEntity3;
import _03_hashset.entity.UserEntity3;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest03 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
        retrieveUser();
    }

    private static void insertUser() {
        UserEntity3 user = new UserEntity3();
        user.setUserName("ibrahim");

        AddressEntity3 address1 = new AddressEntity3();
        address1.setStreet("Street Name");
        address1.setCity("City Name");
        address1.setPostCode("postcode");

        AddressEntity3 address2 = new AddressEntity3();
        address2.setStreet("Street Name 2");
        address2.setCity("City Name 2");
        address2.setPostCode("postcode 2");

        user.getListOfAddresses().add(address1);
        user.getListOfAddresses().add(address2);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    private static void retrieveUser() {
        Session session;
        try{
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex){
            System.err.println("error occurred");
            return;
        }

        session.beginTransaction();
        UserEntity3 user = session.get(UserEntity3.class, 1);
        System.out.println(user);
        session.close();
    }

}