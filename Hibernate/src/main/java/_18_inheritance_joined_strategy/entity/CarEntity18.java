package _18_inheritance_joined_strategy.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_entity18")
public class CarEntity18 extends VehicleEntity18 {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
