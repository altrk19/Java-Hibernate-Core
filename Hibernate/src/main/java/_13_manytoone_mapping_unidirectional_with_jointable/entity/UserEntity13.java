package _13_manytoone_mapping_unidirectional_with_jointable.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity13")
public class UserEntity13 {

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
        return "UserEntity13{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}