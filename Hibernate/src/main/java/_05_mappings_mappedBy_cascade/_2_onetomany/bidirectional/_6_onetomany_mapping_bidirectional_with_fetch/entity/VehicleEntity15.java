package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._6_onetomany_mapping_bidirectional_with_fetch.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity15")
public class VehicleEntity15 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    //we have defined onetomany in user entity. we also define manytoone because if we have vehicle object but we want to it's user info. so we have to define reverse relation.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity15
            userMappedBy;

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

    public UserEntity15 getUser() {
        return userMappedBy;
    }

    public void setUser(UserEntity15 userMappedBy) {
        this.userMappedBy = userMappedBy;
    }

    @Override
    public String toString() {
        return "VehicleEntity15{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
