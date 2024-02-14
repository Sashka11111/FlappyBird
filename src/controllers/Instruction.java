package controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Instruction {
  private String filePath;

  public Instruction(String filePath) {
    this.filePath = filePath;
  }

  public void displayInstructions() {
    try {
      // Створення об'єкту File для файлу з вказаним шляхом
      File file = new File(filePath);

      // Створення об'єкту Scanner для зчитування з файлу
      Scanner scanner = new Scanner(file);

      // Виведення вмісту файлу рядок за рядком
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
      }

      // Закриття Scanner
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Файл інструкцій не знайдено: " + e.getMessage());
    }
  }
}
