package _12_onetomany_mapping_bidirectional_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity12")
public class UserEntity12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany(mappedBy = "userMappedBy")
    private List<VehicleEntity12> vehicles = new ArrayList<VehicleEntity12>();

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

    public List<VehicleEntity12> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity12> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity12{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}