package views;
import controllers.Game;
import controllers.Instruction;
import java.util.Scanner;

public class MainMenu {
  private Scanner scanner; // Об'єкт Scanner для отримання введення від користувача

  public MainMenu() {
    this.scanner = new Scanner(System.in);
  }

  // Метод для відображення головного меню
  public void displayMainMenu() {
    int choice;
    do {
      String art = "          __\n" +
          "         /'{>\n" +
          "     ____) (____\n" +
          "   //'--;   ;--'\\\\\n" +
          "  ///////\\_/\\\\\\\\\\\n" +
          "         m m";

      System.out.println(art);
      System.out.println("=== Головне меню ===");
      System.out.println("1. Розпочати гру");
      System.out.println("2. Інструкція");
      System.out.println("3. Вийти");

      System.out.print("Виберіть опцію: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Очищуємо буфер введення

      switch (choice) {
        case 1:
          startGame();
          break;
        case 2:
          displayInstructions();
          break;
        case 3:
          System.out.println("Гра завершена.");
          break;
        default:
          System.out.println("Невідома опція.");
      }
    } while (choice != 3);
  }

  // Метод для відображення інструкцій
  private void displayInstructions() {
    System.out.println("=== Інструкція ===");
    Instruction instruction = new Instruction("Data/instruction.txt");
    instruction.displayInstructions();
  }
  private void startGame() {
    Game game = new Game();
    game.start();
  }
}
