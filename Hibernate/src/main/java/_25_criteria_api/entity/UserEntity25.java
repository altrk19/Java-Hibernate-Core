package _25_criteria_api.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity25")
public class UserEntity25 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

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

    @Override
    public String toString() {
        return "UserEntity25{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
