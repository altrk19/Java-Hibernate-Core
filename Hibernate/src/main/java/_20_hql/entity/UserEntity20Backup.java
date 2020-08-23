package _20_hql.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity20_backup")
public class UserEntity20Backup {

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
        return "UserEntity20Backup{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
