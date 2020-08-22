package _17_inheritance_table_per_class_strategy.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle_entity17")
public class MotorcycleEntity17 extends VehicleEntity17 {
    private String handlebar;

    public String getHandlebar() {
        return handlebar;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }
}
