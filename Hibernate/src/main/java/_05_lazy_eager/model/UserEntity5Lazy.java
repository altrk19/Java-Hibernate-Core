package _05_lazy_eager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user_entity5")
public class UserEntity5Lazy {

    @Id
    @GeneratedValue
    private int userId;

    private String userName;

    @ElementCollection
    @JoinTable(name = "user_entity5_address", joinColumns = @JoinColumn(name = "user_entity5_id"))
    private Collection<AddressEntity5> listOfAddresses = new ArrayList<AddressEntity5>();

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


    public Collection<AddressEntity5> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<AddressEntity5> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return "username: " + getUserName();
    }

}