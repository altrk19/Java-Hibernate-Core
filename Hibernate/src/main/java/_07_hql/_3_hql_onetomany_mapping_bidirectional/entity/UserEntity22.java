package _07_hql._3_hql_onetomany_mapping_bidirectional.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity22")
public class UserEntity22 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany
    @JoinTable(name = "user_vehicle", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private List<VehicleEntity22> vehicles = new ArrayList<VehicleEntity22>();

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

    public List<VehicleEntity22> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity22> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity22{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}