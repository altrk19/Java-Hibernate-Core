package _24_namedQuery_namedNativeQuery_sqlNativeQuery.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity24")
@NamedQuery(name = "UserEntity24.byId", query = "FROM UserEntity24 WHERE userId = :userId")
@NamedNativeQuery(name = "UserEntity24.byNameNativeQuery", query = "SELECT * FROM user_entity24 WHERE userName = :userName", resultClass = UserEntity24.class)
public class UserEntity24 {

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
        return "UserEntity24{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
