package rw.ac.rca.webapp.orm;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee  extends Person{
    public Employee(String firstName, String lastName, String phoneNumber, Date dateOfBirth) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
    }

    public Employee() {

    }
}
