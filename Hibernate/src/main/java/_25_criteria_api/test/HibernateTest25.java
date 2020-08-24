package _25_criteria_api.test;

import _25_criteria_api.entity.UserEntity25;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class HibernateTest25 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUser();

        getUser();

        getUserMultiplePredicate();

        getTotalUserCount_AggregateFunction();

        groupBy_Having();

        orderBy();

    }

    private static void createUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            UserEntity25 user = new UserEntity25();
            user.setUserName("User" + i);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();

    }

    private static void getUserMultiplePredicate() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<UserEntity25> criteriaQuery = builder.createQuery(UserEntity25.class);
        Root<UserEntity25> root = criteriaQuery.from(UserEntity25.class);

        Predicate predicateForUserId
                = builder.equal(root.get("userId"), 3);
        Predicate predicateForUserName
                = builder.equal(root.get("userName"), "User2");
        Predicate predicateForUser
                = builder.and(predicateForUserId, predicateForUserName);

        criteriaQuery.where(predicateForUser);

        UserEntity25 user = session.createQuery(criteriaQuery).uniqueResult();
        System.out.println(user);
        //UserEntity25{userId=3, userName='User2'}

        session.close();
        System.out.println("----------------------");
    }

    private static void getUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<UserEntity25> criteriaQuery = builder.createQuery(UserEntity25.class);
        Root<UserEntity25> root = criteriaQuery.from(UserEntity25.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("userId"), 2));

        Query<UserEntity25> query = session.createQuery(criteriaQuery);

        UserEntity25 user = query.uniqueResult();
        System.out.println(user);
        //UserEntity25{userId=2, userName='User1'}

        session.close();
        System.out.println("----------------------");
    }

    private static void getUserCriteriaApi2() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<UserEntity25> criteriaQuery = builder.createQuery(UserEntity25.class);
        Root<UserEntity25> root = criteriaQuery.from(UserEntity25.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("userId"), 2));

        Query<UserEntity25> query = session.createQuery(criteriaQuery);

        UserEntity25 user = query.uniqueResult();
        System.out.println(user);
        //UserEntity25{userId=2, userName='User1'}

        session.close();
        System.out.println("----------------------");
    }

    private static void getTotalUserCount_AggregateFunction() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<UserEntity25> root = criteriaQuery.from(UserEntity25.class);

        criteriaQuery.select(builder.count(root));

        Long result = session.createQuery(criteriaQuery).getSingleResult();
        System.out.println("Total No Of Users:" + result);
        //Total No Of Users:10


        session.close();
    }

    private static void groupBy_Having(){

//        criteriaQuery.groupBy(root.get("department"));
//        criteriaQuery.having(builder.greaterThan(builder.sum(root.get("salary")), 200000.00));

    }

    private static void orderBy(){

//        criteriaQuery.select(root);
//        criteriaQuery.orderBy(builder.asc(root.get("salary")));
//        criteriaQuery.orderBy(builder.desc(root.get("salary")));

    }

}
