package _06_onetoone_mapping.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity6")
public class VehicleEntity6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "VehicleEntity6{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
