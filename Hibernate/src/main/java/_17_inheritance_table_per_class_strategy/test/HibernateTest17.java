package _17_inheritance_table_per_class_strategy.test;

import _17_inheritance_table_per_class_strategy.entity.CarEntity17;
import _17_inheritance_table_per_class_strategy.entity.MotorcycleEntity17;
import _17_inheritance_table_per_class_strategy.entity.VehicleEntity17;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest17 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        VehicleEntity17 vehicle1 = new VehicleEntity17();
        vehicle1.setVehicleName("vehicle1");


        CarEntity17 car1 = new CarEntity17();
        car1.setVehicleName("Audi");
        car1.setSteeringWheel("Audi Wheel");

        MotorcycleEntity17 motor1 = new MotorcycleEntity17();
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
