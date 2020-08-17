package _10_manytoone_mapping_unidirectional_donotuse.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity10")
public class VehicleEntity10 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private UserEntity10 user;

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

    public UserEntity10 getUser() {
        return user;
    }

    public void setUser(UserEntity10 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity10{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
