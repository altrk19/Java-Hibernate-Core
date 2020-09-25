package _05_mappings_mappedBy_cascade._4_manytomany._1_manytomany_mapping_without_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle_entity13")
public class VehicleEntity14 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToMany
    private List<UserEntity14> userList = new ArrayList<UserEntity14>();

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

    public List<UserEntity14> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity14> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VehicleEntity13{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
