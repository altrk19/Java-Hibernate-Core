package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._6_onetomany_mapping_bidirectional_with_fetch.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity15")
public class UserEntity15 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany(mappedBy = "userMappedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VehicleEntity15> vehicles = new ArrayList<>();

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

    public List<VehicleEntity15> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity15> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity15{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}