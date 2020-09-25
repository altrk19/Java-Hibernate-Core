package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._1_onetomany_mapping_bidirectional_without_jointable_without_mappedBy.entity;


import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity9")
public class VehicleEntity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "user_id")
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
