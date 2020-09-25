package _10_cache.test;

import _10_cache.entity.UserEntity26;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest26 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        createUser();

        getUser1(); //it gets from cache for retrievedUser2

        getUser2(); //it gets from db because of session closed for retrievedUser2

        //getUser3(); //it gets from secondary cache

    }

    private static void createUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        UserEntity26 user = new UserEntity26();
        user.setUserName("UserName");
        session.save(user);

        session.getTransaction().commit();
        session.close();

    }

    private static void getUser1() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();


        UserEntity26 retrievedUser1 = session.get(UserEntity26.class,1);
        retrievedUser1.setUserName("updatedUserName");

        UserEntity26 retrievedUser2 = session.get(UserEntity26.class,1);

        //Hibernate send sql query once time to database
        //Hibernate: select userentity0_.userId as userId1_0_0_, userentity0_.userName as userName2_0_0_ from user_entity26 userentity0_ where userentity0_.userId=?

        session.close();
        System.out.println("--------------------------");
    }

    private static void getUser2() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        UserEntity26 retrievedUser1 = session.get(UserEntity26.class,1);
        retrievedUser1.setUserName("updatedUserName");

        session.close();




        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();

        UserEntity26 retrievedUser2 = session2.get(UserEntity26.class,1);

        session2.close();
        //Hibernate send sql query two times to database
        //Hibernate: select userentity0_.userId as userId1_0_0_, userentity0_.userName as userName2_0_0_ from user_entity26 userentity0_ where userentity0_.userId=?
        //Hibernate: select userentity0_.userId as userId1_0_0_, userentity0_.userName as userName2_0_0_ from user_entity26 userentity0_ where userentity0_.userId=?
        System.out.println("--------------------------");

    }

    private static void getUser3() {
//        Note: Added following items

//        UserEntity26.java
//        @Cacheable
//        @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

//        hibernate.cfg.xml line:25
//        <property name="hibernate.cache.use_second_level_cache">true</property>
//        <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        UserEntity26 retrievedUser1 = session.get(UserEntity26.class,1);
        retrievedUser1.setUserName("updatedUserName");

        session.close();




        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();

        UserEntity26 retrievedUser2 = session2.get(UserEntity26.class,1);

        session2.close();
        //Hibernate send sql query once time to database
        //Hibernate: select userentity0_.userId as userId1_0_0_, userentity0_.userName as userName2_0_0_ from user_entity26 userentity0_ where userentity0_.userId=?
        System.out.println("--------------------------");

    }
}
