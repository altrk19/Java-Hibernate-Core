package _05_mappings_mappedBy_cascade._2_onetomany.bidirectional._1_onetomany_mapping_bidirectional_without_jointable_without_mappedBy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_entity9")
public class UserEntity9 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToMany
    private List<VehicleEntity9> vehicles = new ArrayList<VehicleEntity9>();

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

    public List<VehicleEntity9> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity9> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "UserEntity9{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}