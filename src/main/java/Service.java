
import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.toString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if (line == null)
        break;
      ret.add(Student.parse(line));
    }
    reader.close();
    return ret;
  }

  public Collection<Student> findStudentByName(String name) throws IOException {
    Collection<Student> allStudents = getStudents();
    Collection<Student> result = new ArrayList<>();
    for (Student student : allStudents) {
      if (student.getName().equalsIgnoreCase(name)) {
        result.add(student);
      }
    }
    return result;
  }

  public void deleteStudent(Student studentToDelete) throws IOException {
    Collection<Student> students = getStudents();
    var f = new FileWriter("db.txt");
    var b = new BufferedWriter(f);
    
    for (Student student : students) {
      if (!student.toString().equals(studentToDelete.toString())) {
        b.write(student.toString());
        b.newLine();
      }
    }
    b.close();
  }
}
