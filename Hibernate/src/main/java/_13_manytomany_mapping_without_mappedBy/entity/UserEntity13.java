package _13_manytomany_mapping_without_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity13")
public class UserEntity13 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @ManyToMany
    @JoinTable(name = "user_vehicle_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private List<VehicleEntity13> vehicleMappedBy = new ArrayList<VehicleEntity13>();

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

    public List<VehicleEntity13> getVehicles() {
        return vehicleMappedBy;
    }

    public void setVehicles(List<VehicleEntity13> vehicleMappedBy) {
        this.vehicleMappedBy = vehicleMappedBy;
    }

    @Override
    public String toString() {
        return "UserEntity13{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicleMappedBy +
                '}';
    }
}