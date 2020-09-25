package _07_hql._1_hql.test;

import _07_hql._1_hql.entity.UserEntity20;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateTest02InsertUpdateDeleteQueries {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUser();         //Please see note(under notes package) why we are creating user firstly.

        hqlInsertQuery();

        hqlUpdateQuery();

        hqlDeleteQuery();

    }

    private static void createUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            UserEntity20 user = new UserEntity20();
            user.setUserName("User" + i);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();

    }

    private static void hqlInsertQuery() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hqlInsertQuery = "INSERT INTO UserEntity20Backup(userId, userName)" +
                "SELECT u.userId,u.userName FROM UserEntity20 u WHERE u.userId = :userId";

        Query query = session.createQuery(hqlInsertQuery);
        query.setParameter("userId", 1);


        int executeUpdate = query.executeUpdate();
        if (executeUpdate > 0) {
            System.out.println(executeUpdate + " records are inserted successfully..");
        }

        session.getTransaction().commit();
        session.close();
    }

    private static void hqlUpdateQuery() {
        int userId = 2;
        String newUserName = "newUserName2";

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String HQL = "UPDATE UserEntity20 set userName = :newUserName WHERE userId = :userId";

        Query query = session.createQuery(HQL);
        query.setParameter("newUserName", newUserName);
        query.setParameter("userId", userId);

        int executeUpdate = query.executeUpdate();

        session.getTransaction().commit();
        if (executeUpdate > 0) {
            System.out.println("Username is updated..");
        }
    }

    private static void hqlDeleteQuery() {
        int userId = 4;

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String HQL = "DELETE FROM UserEntity20 WHERE userId = :userId";

        Query query = session.createQuery(HQL);
        query.setParameter("userId", userId);

        int executeUpdate = query.executeUpdate();

        session.getTransaction().commit();
        if (executeUpdate > 0) {
            System.out.println("User " + userId + " is deleted..");
        }
    }
}
