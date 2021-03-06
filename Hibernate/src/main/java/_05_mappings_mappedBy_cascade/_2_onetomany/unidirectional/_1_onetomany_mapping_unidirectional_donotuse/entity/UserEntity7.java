package _05_mappings_mappedBy_cascade._2_onetomany.unidirectional._1_onetomany_mapping_unidirectional_donotuse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity7")
public class UserEntity7 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany
    private List<VehicleEntity7> vehicles = new ArrayList<VehicleEntity7>();

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

    public List<VehicleEntity7> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity7> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity7{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}