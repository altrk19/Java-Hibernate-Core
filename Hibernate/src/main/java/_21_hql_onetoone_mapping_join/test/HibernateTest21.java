package _21_hql_onetoone_mapping_join.test;

import _21_hql_onetoone_mapping_join.entity.UserEntity21;
import _21_hql_onetoone_mapping_join.entity.VehicleEntity21;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest21 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();

        getUserAndVehicleByUserId();

        getUserNameAndVehicleNameByUserId();

    }

    private static void insertUser() {
        UserEntity21 user1 = new UserEntity21();
        user1.setUserName("Ali");

        VehicleEntity21 vehicle1 = new VehicleEntity21();
        vehicle1.setVehicleName("vehicle name 1");
        user1.setVehicle(vehicle1);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user1);
        session.save(vehicle1);

        session.getTransaction().commit();
        session.close();
    }

    private static void getUserAndVehicleByUserId() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hqlQuery = "FROM UserEntity21 user LEFT JOIN FETCH user.vehicle WHERE user.userId = :userId";        //see notes for what is fetch
        UserEntity21 user = session.createQuery(hqlQuery, UserEntity21.class).setParameter("userId", 1).uniqueResult();

        System.out.println(user);
        //UserEntity21{userId=1, userName='Ali', vehicle=VehicleEntity21{vehicleId=1, vehicleName='vehicle name 1'}}

        VehicleEntity21 vehicle = user.getVehicle();
        System.out.println(vehicle);
        //VehicleEntity21{vehicleId=1, vehicleName='vehicle name 1'}

        session.close();
    }

    private static void getUserNameAndVehicleNameByUserId() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hqlQuery =
                "SELECT user.userName,veh.vehicleName FROM UserEntity21 user LEFT JOIN user.vehicle veh WHERE user.userId = :userId";
        Query<Object[]> query = session.createQuery(hqlQuery);
        query.setParameter("userId", 1);
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            String userName = (String) objects[0];
            String vehicleName = (String) objects[1];

            System.out.println("Retrieved userName and vehicleName for userId:1");
            System.out.println(userName + "\t" + vehicleName);
            //Ali	vehicle name 1

        }
        session.close();
    }
}