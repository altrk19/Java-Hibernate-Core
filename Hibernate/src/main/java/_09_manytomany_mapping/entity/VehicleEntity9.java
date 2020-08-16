package _09_manytomany_mapping.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle_entity9")
public class VehicleEntity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleName;

    @ManyToMany(mappedBy = "vehicleMappedBy")
    private List<UserEntity9> userList = new ArrayList<UserEntity9>();

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

    public List<UserEntity9> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity9> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VehicleEntity9{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
