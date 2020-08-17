package _09_onetomany_mapping_bidirectional_best.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity9")
public class VehicleEntity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private UserEntity9 user;

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

    public UserEntity9 getUser() {
        return user;
    }

    public void setUser(UserEntity9 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity9{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}