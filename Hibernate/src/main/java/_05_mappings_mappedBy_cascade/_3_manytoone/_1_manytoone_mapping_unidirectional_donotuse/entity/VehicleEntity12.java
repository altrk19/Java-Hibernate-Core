package _05_mappings_mappedBy_cascade._3_manytoone._1_manytoone_mapping_unidirectional_donotuse.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity12")
public class VehicleEntity12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private UserEntity12 user;

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

    public UserEntity12 getUser() {
        return user;
    }

    public void setUser(UserEntity12 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity12{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
