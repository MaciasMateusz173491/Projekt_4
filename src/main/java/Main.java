import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Service s = new Service();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("Wybierz opcję:");
      System.out.println("1. Wprowadź nowego studenta");
      System.out.println("2. Wyświetl wszystkich studentów");
      System.out.println("3. Wyjdź");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Czyszczenie bufora

      switch (choice) {
        case 1:
          try {
            System.out.println("Podaj imię studenta:");
            String name = scanner.nextLine();
            System.out.println("Podaj wiek studenta:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Czyszczenie bufora
            s.addStudent(new Student(name, age));
            System.out.println("Student został dodany!");
          } catch (IOException e) {
            System.out.println("Błąd podczas dodawania studenta: " + e.getMessage());
          }
          break;

        case 2:
          try {
            System.out.println("Lista studentów:");
            for (Student current : s.getStudents()) {
              System.out.println(current.ToString());
            }
          } catch (IOException e) {
            System.out.println("Błąd podczas pobierania listy studentów: " + e.getMessage());
          }
          break;

        case 3:
          running = false;
          System.out.println("Zakończono program.");
          break;

        default:
          System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
      }
    }

    scanner.close();
  }
}
