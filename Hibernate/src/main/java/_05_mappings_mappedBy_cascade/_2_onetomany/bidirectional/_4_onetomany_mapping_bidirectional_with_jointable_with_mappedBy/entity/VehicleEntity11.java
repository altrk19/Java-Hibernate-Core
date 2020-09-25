package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._4_onetomany_mapping_bidirectional_with_jointable_with_mappedBy.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity11")
public class VehicleEntity11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne
    @JoinTable(name = "user_vehicle", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private UserEntity11 userMappedBy;

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

    public UserEntity11 getUser() {
        return userMappedBy;
    }

    public void setUser(UserEntity11 userMappedBy) {
        this.userMappedBy = userMappedBy;
    }

    @Override
    public String toString() {
        return "VehicleEntity11{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
