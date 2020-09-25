package _10_cache.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity26")
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserEntity26 {

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
        return "UserEntity26{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
