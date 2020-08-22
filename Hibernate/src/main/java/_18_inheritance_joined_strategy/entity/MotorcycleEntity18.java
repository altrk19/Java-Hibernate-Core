package _18_inheritance_joined_strategy.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle_entity18")
public class MotorcycleEntity18 extends VehicleEntity18 {
    private String handlebar;

    public String getHandlebar() {
        return handlebar;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }
}
