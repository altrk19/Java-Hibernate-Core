package _09_manytomany_mapping.entity;

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

    @ManyToMany
    private List<VehicleEntity9> vehicleMappedBy = new ArrayList<VehicleEntity9>();

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
        return vehicleMappedBy;
    }

    public void setVehicles(List<VehicleEntity9> vehicleMappedBy) {
        this.vehicleMappedBy = vehicleMappedBy;
    }

    @Override
    public String toString() {
        return "UserEntity9{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicles=" + vehicleMappedBy +
                '}';
    }
}