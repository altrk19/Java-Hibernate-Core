package _24_namedQuery_namedNativeQuery_sqlNativeQuery.test;

import _24_namedQuery_namedNativeQuery_sqlNativeQuery.entity.UserEntity24;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest24 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUser();

        getUserByIdNamedQuery();

        getUserByNameNamedNativeQuery();

        getAllUsersSqlNativeQuery();

    }

    private static void createUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            UserEntity24 user = new UserEntity24();
            user.setUserName("User" + i);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();

    }

    private static void getUserByIdNamedQuery() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("UserEntity24.byId");
        UserEntity24 user = (UserEntity24) query.setParameter("userId", 3).uniqueResult();

        System.out.println(user);
        //UserEntity24{userId=3, userName='User2'}

        session.close();
        System.out.println("----------------------");
    }

    private static void getUserByNameNamedNativeQuery() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("UserEntity24.byNameNativeQuery");
        UserEntity24 user = (UserEntity24) query.setParameter("userName", "User5").uniqueResult();

        System.out.println(user);
        //UserEntity24{userId=6, userName='User5'}

        session.close();
        System.out.println("----------------------");
    }

    private static void getAllUsersSqlNativeQuery() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createNativeQuery("SELECT * FROM user_entity24");
        List<Object[]> users = query.list();

        for (Object[] objects : users) {
            int userId = (int) objects[0];
            String userName = (String) objects[1];

            System.out.println("User Id:" + userId);
            System.out.println("User Name:" + userName);
        }
        //User Id:1
        //User Name:User0
        //...
        //User Id:10
        //User Name:User9

        session.close();
    }

}
