package _12_onetomany_mapping_bidirectional_mappedBy.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity12")
public class VehicleEntity12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity12 userMappedBy;

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
        return userMappedBy;
    }

    public void setUser(UserEntity12 userMappedBy) {
        this.userMappedBy = userMappedBy;
    }

    @Override
    public String toString() {
        return "VehicleEntity12{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
