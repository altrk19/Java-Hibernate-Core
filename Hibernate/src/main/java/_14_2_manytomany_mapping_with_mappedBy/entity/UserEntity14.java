package _14_2_manytomany_mapping_with_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity14")
public class UserEntity14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @ManyToMany
    @JoinTable(name = "vehicle_user_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private List<VehicleEntity14> vehicleMappedBy = new ArrayList<VehicleEntity14>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<VehicleEntity14> getVehicles() {
        return vehicleMappedBy;
    }

    public void setVehicles(List<VehicleEntity14> vehicleMappedBy) {
        this.vehicleMappedBy = vehicleMappedBy;
    }

    @Override
    public String toString() {
        return "UserEntity14{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicleMappedBy +
                '}';
    }
}