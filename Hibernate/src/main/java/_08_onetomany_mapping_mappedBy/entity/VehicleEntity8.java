package _08_onetomany_mapping_mappedBy.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity8")
public class VehicleEntity8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity8 userMappedBy;

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

    public UserEntity8 getUser() {
        return userMappedBy;
    }

    public void setUser(UserEntity8 userMappedBy) {
        this.userMappedBy = userMappedBy;
    }

    @Override
    public String toString() {
        return "VehicleEntity8{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
