package _04_collection._2_element_collection.test;

import _04_collection._2_element_collection.entity.AddressEntity4;
import _04_collection._2_element_collection.entity.UserEntity4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest04 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();
    }

    private static void insertUser() {
        UserEntity4 user = new UserEntity4();
        user.setUserName("Ali");

        AddressEntity4 address1 = new AddressEntity4();
        address1.setStreet("Street 1");
        address1.setCity("City 1");
        address1.setPostCode("postcode 1");

        AddressEntity4 address2 = new AddressEntity4();
        address2.setStreet("Street 2");
        address2.setCity("City 2");
        address2.setPostCode("postcode 2");

        user.getListOfAddresses().add(address1);
        user.getListOfAddresses().add(address2);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

}
