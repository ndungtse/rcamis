package rw.ac.rca.webapp.orm;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Parent extends Person{
    public Parent(String firstName, String lastName, String phoneNumber, Date dateOfBirth) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
    }

    public Parent() {

    }
}
