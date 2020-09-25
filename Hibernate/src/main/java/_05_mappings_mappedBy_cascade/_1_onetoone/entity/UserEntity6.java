package _05_mappings_mappedBy_cascade._1_onetoone.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity6")
public class UserEntity6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity6 vehicle;

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

    public VehicleEntity6 getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity6 vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "UserEntity6{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}