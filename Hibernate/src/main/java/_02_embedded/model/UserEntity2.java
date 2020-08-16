package _02_embedded.model;

import javax.persistence.*;

@Entity
@Table(name = "user_entity2")
public class UserEntity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_stret")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "postCode", column = @Column(name = "home_post_code"))
    })
    private AddressEntity2 homeAddress;

    @Embedded
    private AddressEntity2 officeAddress;

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

    public AddressEntity2 getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(AddressEntity2 homeAddress) {
        this.homeAddress = homeAddress;
    }

    public AddressEntity2 getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(AddressEntity2 officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "UserEntity2{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", homeAddress=" + homeAddress +
                ", officeAddress=" + officeAddress +
                '}';
    }
}
