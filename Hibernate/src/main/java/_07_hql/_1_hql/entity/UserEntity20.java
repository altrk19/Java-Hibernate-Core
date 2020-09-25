package _07_hql._1_hql.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity20")
public class UserEntity20 {

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
        return "UserEntity20{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
