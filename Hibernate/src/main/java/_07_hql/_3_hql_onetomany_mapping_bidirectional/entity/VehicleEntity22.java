package _07_hql._3_hql_onetomany_mapping_bidirectional.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity22")
public class VehicleEntity22 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private UserEntity22 user;

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

    public UserEntity22 getUser() {
        return user;
    }

    public void setUser(UserEntity22 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity22{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
