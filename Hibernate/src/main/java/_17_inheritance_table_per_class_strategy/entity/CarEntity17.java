package _17_inheritance_table_per_class_strategy.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_entity17")
public class CarEntity17 extends VehicleEntity17 {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
