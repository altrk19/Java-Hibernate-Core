package _08_onetomany_mapping_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity8")
public class UserEntity8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany(mappedBy = "userMappedBy")
    private List<VehicleEntity8> vehicles = new ArrayList<VehicleEntity8>();

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

    public List<VehicleEntity8> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity8> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity8{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}