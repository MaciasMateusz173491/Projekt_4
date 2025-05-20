
import java.io.IOException;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Collection<Student> students = s.getStudents();
            
            System.out.println("Lista studentów z pliku db.txt:");
            System.out.println("------------------------------");
            
            for (Student student : students) {
                System.out.println(student.toString());
            }
            
            if (students.isEmpty()) {
                System.out.println("Brak studentów w bazie danych.");
            }
            
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }
    }
}
