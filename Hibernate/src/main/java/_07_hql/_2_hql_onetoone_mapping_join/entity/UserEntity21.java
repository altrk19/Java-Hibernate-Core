package _07_hql._2_hql_onetoone_mapping_join.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity21")
public class UserEntity21 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity21 vehicle;

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

    public VehicleEntity21 getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity21 vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "UserEntity21{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}