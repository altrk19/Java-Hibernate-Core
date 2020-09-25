package _05_mappings_mappedBy_cascade._3_manytoone._2_manytoone_mapping_unidirectional_with_jointable.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity13")
public class VehicleEntity13 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    @JoinTable(name = "vehicle_user", joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private UserEntity13 user;

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

    public UserEntity13 getUser() {
        return user;
    }

    public void setUser(UserEntity13 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity13{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
