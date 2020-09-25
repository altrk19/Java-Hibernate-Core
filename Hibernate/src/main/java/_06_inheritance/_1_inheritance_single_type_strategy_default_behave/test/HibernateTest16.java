package _06_inheritance._1_inheritance_single_type_strategy_default_behave.test;

import _06_inheritance._1_inheritance_single_type_strategy_default_behave.entity.CarEntity16;
import _06_inheritance._1_inheritance_single_type_strategy_default_behave.entity.MotorcycleEntity16;
import _06_inheritance._1_inheritance_single_type_strategy_default_behave.entity.VehicleEntity16;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest16 {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        VehicleEntity16 vehicle1 = new VehicleEntity16();
        vehicle1.setVehicleName("vehicle1");


        CarEntity16 car1 = new CarEntity16();
        car1.setVehicleName("Audi");
        car1.setSteeringWheel("Audi Wheel");

        MotorcycleEntity16 motor1 = new MotorcycleEntity16();
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
