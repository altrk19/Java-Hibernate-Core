package _07_hql._1_hql.test;

import _07_hql._1_hql.entity.UserEntity20;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest01SelectQuery {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUsers();

        hqlQuery1GetAllUsers();

        hqlQuery2WhereCondition();

        hqlQuery3WithParameterDoNotUseLikeThisBecauseOfSqlInjection();

        hqlQuery4GetUserById();

        hqlQuery5GetUserIdAndName();

        hqlQuery6GetAllUsersName();

        hqlQuery7GetAllUsersNameAndId();


    }

    private static void hqlQuery1GetAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<UserEntity20> query = session.createQuery("from UserEntity20", UserEntity20.class);
        List<UserEntity20> users = query.getResultList();
        session.close();

        System.out.println("Size of the list : " + users.size());
        //Size of the list : 10

    }

    private static void hqlQuery2WhereCondition() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<UserEntity20> query = session.createQuery("from UserEntity20 where userId > 5", UserEntity20.class);
        List<?> users = query.getResultList();
        session.getTransaction().commit();

        session.close();
        System.out.println("Size of the list that contains userId greater than 5 : " + users.size());
        //Size of the list that contains userId greater than 5 : 5
    }


    private static void hqlQuery3WithParameterDoNotUseLikeThisBecauseOfSqlInjection() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String minUserId = "5 or 1 = 1";
        Query<UserEntity20> query =
                session.createQuery("from UserEntity20 where userId >" + minUserId, UserEntity20.class);
        List<?> users = query.getResultList();

        session.close();

        System.out.println("Size of the list that contains userId greater than 5 with SQL Injection : " + users.size());
        //Size of the list that contains userId greater than 5 with SQL Injection : 10
        //Result is 10 because retrieved all data
    }

    private static void hqlQuery4GetUserById() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int empId = 2;
        Query<UserEntity20> query = session.createQuery("from UserEntity20 WHERE userId = :userId", UserEntity20.class);
        query.setParameter("userId", empId);
        UserEntity20 user = query.getSingleResult();

        session.close();

        System.out.println(user);
        //UserEntity20{userId=2, userName='User1'}
    }

    private static void hqlQuery5GetUserIdAndName() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String minUserId = "5";
        String userName = "User8";
        Query<UserEntity20> query =
                session.createQuery("from UserEntity20 where userId > :userId and userName = :userName",
                        UserEntity20.class);
        query.setParameter("userId", Integer.parseInt(minUserId));
        query.setParameter("userName", userName);

        UserEntity20 user = query.getSingleResult();

        session.close();

        System.out.println(user);
        //UserEntity20{userId=9, userName='User8'}
    }

    private static void hqlQuery6GetAllUsersName() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<String> query = session.createQuery("SELECT userName from UserEntity20", String.class);

        query.list().forEach(System.out::println);
        //User0
        //User1
        //...
        //User9

        session.close();
    }

    private static void hqlQuery7GetAllUsersNameAndId() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT userName,userId from UserEntity20");
        List<Object[]> list = query.list();
        for (Object[] object : list) {
            String userName = (String) object[0];
            int userId = (int) object[1];
            System.out.println(userId + "\t" + userName);
        }

        //1	    User0
        //2	    User1
        //...
        //10	User9

        session.close();
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
