import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        Instructor tempInstructor = new Instructor("Tomik","Varga","tomik@tomik.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail("youtube.com/tomikfortnite","tomik fortnite");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        session.beginTransaction();

        System.out.println("Commit transaction");
        session.getTransaction().commit();

        System.out.println("Done");

    } finally {
        factory.close();
    }
}
