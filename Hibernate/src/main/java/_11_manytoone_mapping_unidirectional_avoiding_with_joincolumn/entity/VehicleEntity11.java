package _11_manytoone_mapping_unidirectional_avoiding_with_joincolumn.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_entity11")
public class VehicleEntity11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    @JoinTable(name = "vehicle_user", joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private UserEntity11 user;

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
        return user;
    }

    public void setUser(UserEntity11 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VehicleEntity11{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
