import hibernate.Instructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    private int id;
    private String title;
    private Instructor instructor;

    public Course(){

    }

    public Course(String title) {
        this.title = title;
    }
}
