import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        Instructor tempInstructor = new Instructor("John","Wick","john@wick.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail("youtube.com/youwillbedeath","fortnite john wick skin ");

        session.beginTransaction();

        session.save(tempInstructor);

        System.out.println("Commit transaction");
        session.getTransaction().commit();

        System.out.println("selected instructor "+tempInstructorDetail.getInstructor());

        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
