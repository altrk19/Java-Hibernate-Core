package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._3_onetomany_mapping_bidirectional_without_jointable_with_mappedBy.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity10")
public class VehicleEntity10 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity10 userMappedBy;

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
        return userMappedBy;
    }

    public void setUser(UserEntity10 userMappedBy) {
        this.userMappedBy = userMappedBy;
    }

    @Override
    public String toString() {
        return "VehicleEntity10{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
