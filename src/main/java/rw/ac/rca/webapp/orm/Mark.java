package rw.ac.rca.webapp.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mark")
public class Mark {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int Id;
    private int marks;
    private String owner;

    public Mark(String marks, String marksOwner) {
        this.marks = Integer.parseInt(marks);
        this.owner = marksOwner;
    }
}
