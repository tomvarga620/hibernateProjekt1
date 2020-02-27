import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import hibernate.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        session.beginTransaction();

        Course tempCourse = new Course("Pacman - how to fail game");

        tempCourse.addReview(new Review("Tetris is better"));
        tempCourse.addReview(new Review("Course is so fast i cannot fail the game"));
        tempCourse.addReview(new Review("Ninja with fortnite can teach you more"));

        session.save(tempCourse);

        session.getTransaction().commit();
        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
