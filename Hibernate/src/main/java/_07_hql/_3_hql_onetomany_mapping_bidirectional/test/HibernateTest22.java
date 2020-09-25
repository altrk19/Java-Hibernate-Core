package _07_hql._3_hql_onetomany_mapping_bidirectional.test;

import _07_hql._3_hql_onetomany_mapping_bidirectional.entity.UserEntity22;
import _07_hql._3_hql_onetomany_mapping_bidirectional.entity.VehicleEntity22;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest22 {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        insertUser();

        getUserAndVehicleByUserId();

        getUserNameAndVehicleNameByUserId();

    }

    private static void insertUser() {
        UserEntity22 user1 = new UserEntity22();
        user1.setUserName("Ali");

        VehicleEntity22 vehicle1 = new VehicleEntity22();
        vehicle1.setVehicleName("vehicle1");


        VehicleEntity22 vehicle2 = new VehicleEntity22();
        vehicle2.setVehicleName("vehicle2");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);

        //ManyToOne
        vehicle1.setUser(user1);
        vehicle2.setUser(user1);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user1);
        session.save(vehicle1);
        session.save(vehicle2);

        session.getTransaction().commit();
        session.close();
    }

    private static void getUserAndVehicleByUserId() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hqlQuery = "FROM UserEntity22 WHERE userId = :userId";
        UserEntity22 user = session.createQuery(hqlQuery, UserEntity22.class).setParameter("userId", 1).uniqueResult();
        System.out.println(user);
        //UserEntity22{userId=1, userName='Ali', vehicles=[VehicleEntity22{vehicleId=1, vehicleName='vehicle1'}, VehicleEntity22{vehicleId=2, vehicleName='vehicle2'}]}

        if (user != null) {
            user.getVehicles().forEach(System.out::println);
        }
        //VehicleEntity22{vehicleId=1, vehicleName='vehicle1'}
        //VehicleEntity22{vehicleId=2, vehicleName='vehicle2'}

        session.close();
    }

    private static void getUserNameAndVehicleNameByUserId() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String hqlQuery =
                "SELECT user.userName,veh.vehicleName FROM UserEntity22 user LEFT JOIN user.vehicles veh WHERE user.userId = :userId";
        Query<Object[]> query = session.createQuery(hqlQuery);
        query.setParameter("userId", 1);
        List<Object[]> list = query.list();

        for (Object[] objects : list) {
            String userName = (String) objects[0];
            String vehicleName = (String) objects[1];

            System.out.println("Retrieved userName and vehicleName for userId:1");
            System.out.println(userName + "\t" + vehicleName);

        }
        //Retrieved userName and vehicleName for userId:1
        //Ali	vehicle1
        //Retrieved userName and vehicleName for userId:1
        //Ali	vehicle2
        session.close();
    }

}