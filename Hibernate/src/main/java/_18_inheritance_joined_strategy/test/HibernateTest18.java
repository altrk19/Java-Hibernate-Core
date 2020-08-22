package _18_inheritance_joined_strategy.test;

import _18_inheritance_joined_strategy.entity.CarEntity18;
import _18_inheritance_joined_strategy.entity.MotorcycleEntity18;
import _18_inheritance_joined_strategy.entity.VehicleEntity18;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest18 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        VehicleEntity18 vehicle1 = new VehicleEntity18();
        vehicle1.setVehicleName("vehicle1");


        CarEntity18 car1 = new CarEntity18();
        car1.setVehicleName("Audi");
        car1.setSteeringWheel("Audi Wheel");

        MotorcycleEntity18 motor1 = new MotorcycleEntity18();
        motor1.setVehicleName("Kawasaki");
        motor1.setHandlebar("Kawasaki Handlebar");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(vehicle1);
        session.save(car1);
        session.save(motor1);

        session.getTransaction().commit();
        session.close();
    }
}
