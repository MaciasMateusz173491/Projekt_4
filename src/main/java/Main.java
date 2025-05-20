// napisz kod w którym użyjesz klasy Service do dodania studenta do bazy danych
import com.example.demo.Service;
import com.example.demo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        Service service = context.getBean(Service.class);

        Student student = new Student("Jan", "Kowalski", 20);
        service.addStudent(student);

        System.out.println("Student added to database");
        context.close();
    }
}