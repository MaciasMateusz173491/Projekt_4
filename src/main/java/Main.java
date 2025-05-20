
// napisz program
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    for (int i = 1; i <= 20; i++) {
      System.out.println("Naciśnij Enter, aby wyświetlić następną liczbę...");
      scanner.nextLine();
      System.out.println(i);
    }
    scanner.close();
  }
}