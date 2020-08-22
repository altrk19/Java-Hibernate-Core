package _20_hql.test;

import _20_hql.entity.UserEntity20;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class HibernateTest20 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUsers();

        hqlQuery1();

        hqlQuery2WithWhereCondition();

        hqlQuery3WithParameterDoNotUseLikeThisBecauseOfSqlInjection();

        hqlQuery4WithParameterBinding();
    }

    private static void hqlQuery1() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity20");
        List<UserEntity20> users = (List<UserEntity20>) query.getResultList();
        session.getTransaction().commit();
        session.close();

        System.out.println("Size of the list : " + users.size());
        //Size of the list : 10

    }

    private static void hqlQuery2WithWhereCondition() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity20 where userId > 5");
        List<UserEntity20> users = (List<UserEntity20>) query.getResultList();
        session.getTransaction().commit();
        session.close();

        System.out.println("Size of the list that contains userId greater than 5 : " + users.size());
        //Size of the list that contains userId greater than 5 : 5
    }

    private static void hqlQuery3WithParameterDoNotUseLikeThisBecauseOfSqlInjection() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String minUserId = "5 or 1 = 1";
        Query query = session.createQuery("from UserEntity20 where userId >" + minUserId);
        List<UserEntity20> users = (List<UserEntity20>) query.getResultList();
        session.getTransaction().commit();
        session.close();

        System.out.println("Size of the list that contains userId greater than 5 with SQL Injection : " + users.size());
        //Size of the list that contains userId greater than 5 with SQL Injection : 10
        //Result is 10 because retrieved all data
    }

    private static void hqlQuery4WithParameterBinding() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String minUserId = "5";
        String userName = "User8";
        Query query = session.createQuery("from UserEntity20 where userId > :userId and userName = :userName");
        query.setParameter("userId", Integer.parseInt(minUserId));
        query.setParameter("userName", userName);

        List<UserEntity20> users = (List<UserEntity20>) query.getResultList();
        session.getTransaction().commit();
        session.close();

        System.out
                .println("Size of the list that contains userId greater than 5 and userName = User8: " + users.size());
        //Size of the list that contains userId greater than 5 and userName = User8: 1
    }

    private static void createUsers() {
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
}
