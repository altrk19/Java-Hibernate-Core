package _07_onetomany_mapping.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity7")
public class VehicleEntity7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne
    private UserEntity7 user;

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

    public UserEntity7 getUser() {
        return user;
    }

    public void setUser(UserEntity7 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity7{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
