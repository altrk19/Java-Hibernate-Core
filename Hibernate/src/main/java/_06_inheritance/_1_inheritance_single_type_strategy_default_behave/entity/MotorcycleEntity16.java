package _06_inheritance._1_inheritance_single_type_strategy_default_behave.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Motorcycle")
public class MotorcycleEntity16 extends VehicleEntity16 {
    private String handlebar;

    public String getHandlebar() {
        return handlebar;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }
}
