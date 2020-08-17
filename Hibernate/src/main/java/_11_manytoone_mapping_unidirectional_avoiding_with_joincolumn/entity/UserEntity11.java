package _11_manytoone_mapping_unidirectional_avoiding_with_joincolumn.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity11")
public class UserEntity11 {

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
        return "UserEntity11{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}