/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Podaj imię pierwszego studenta:");
      String name1 = scanner.nextLine();
      System.out.println("Podaj wiek pierwszego studenta:");
      int age1 = scanner.nextInt();
      scanner.nextLine();

      System.out.println("Podaj imię drugiego studenta:");
      String name2 = scanner.nextLine();
      System.out.println("Podaj wiek drugiego studenta:");
      int age2 = scanner.nextInt();

      s.addStudent(new Student(name1, age1));
      s.addStudent(new Student(name2, age2));

      var students = s.getStudents();
      for (Student current : students) {
        System.out.println(current.ToString());
      }

    } catch (IOException e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    }
  }
}