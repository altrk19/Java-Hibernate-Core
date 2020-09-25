package _04_collection._2_element_collection.entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user_entity4")
public class UserEntity4 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private int userId;

    private String userName;

    @ElementCollection
    @JoinTable(name = "user_entity4_address", joinColumns = @JoinColumn(name = "user_entity4_id"))
    @GenericGenerator(name = "sequence_gen", strategy = "sequence")
    @CollectionId(columns = { @Column(name="address_entity4_id") }, generator = "sequence_gen", type = @Type(type="long"))
    private Collection<AddressEntity4> listOfAddresses = new ArrayList<AddressEntity4>();

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


    public Collection<AddressEntity4> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<AddressEntity4> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

}