package _03_hashset.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_entity3")
public class UserEntity3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @ElementCollection
    @JoinTable(name = "user_entity3_address", joinColumns = @JoinColumn(name = "user_entity3_id"))
    private Set<AddressEntity3> listOfAddresses = new HashSet<AddressEntity3>();

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

    public Set<AddressEntity3> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Set<AddressEntity3> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return "UserEntity3{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", listOfAddresses=" + listOfAddresses +
                '}';
    }
}