package rw.ac.rca.webapp.orm;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Manager extends Person{
    public Manager(){}
    public Manager(String firstName, String lastName, String phoneNumber, Date managerDOB) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(managerDOB);
    }
}
