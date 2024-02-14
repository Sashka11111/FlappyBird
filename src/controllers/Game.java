package controllers;

import java.util.Scanner;
import models.Bird;
import models.Pipe;

public class Game {
  private static final int SCREEN_HEIGHT = 20;
  private static final int SCREEN_WIDTH = 50;

  private int score = 0; // Змінна для зберігання кількості очок

  public void start() {
    Bird bird = new Bird(0, 5);
    bird.setHorizontalSpeed(3);

    Pipe[] pipes = new Pipe[5];

    pipes[0] = new Pipe(10, false);
    pipes[1] = new Pipe(20, false);
    pipes[2] = new Pipe(30,false);
    pipes[3] = new Pipe(40,false);
    pipes[4] = new Pipe(50,false);
    Scanner scanner = new Scanner(System.in);

    // Цикл гри
    while (true) {
      GameRenderer.render(bird, pipes);

      System.out.println("Натисніть 'w' для стрибка вгору, 's' для стрибка вниз, 'd' для руху вперед або 'q' для виходу.");

      // Очікуємо натискання клавіші
      char input = scanner.next().charAt(0);
      scanner.nextLine(); // Потрібно для очищення буфера вводу після nextChar()

      switch (input) {
        case 'w':
          bird.moveUp();
          break;
        case 's':
          bird.moveDown();
          break;
        case 'd':
          bird.move();
          break;
        case 'q':
          System.out.println("Гра завершена. Кількість очок: " + score);
          System.exit(0);
        default:
          System.out.println("Невідома команда.");
      }
      if (bird.getX() >= SCREEN_WIDTH) {
        System.out.println("Гра завершена. Ви виграли! Кількість очок: " + score);
        break;
      }
      if (bird.getX() == pipes[0].getX()  || bird.getX() == pipes[1].getX() || bird.getX() == pipes[2].getX() || bird.getX() == pipes[3].getX()|| bird.getX() == pipes[4].getX()) {
        score++; // Збільшуємо кількість очок при успішному переході між трубами
        System.out.println("Отримано нове очко!");
      }

      if (bird.getY() < 0 || bird.getY() >= SCREEN_HEIGHT) {
        System.out.println("Гра завершена. Пташка вилетіла за межі екрану. Кількість очок: " + score);
        break;
      }

      if (collisionDetected(bird, pipes)) {
        System.out.println("Гра завершена. Пташка зіткнулася з перешкодою. Кількість очок: " + score);
        break;
      }
    }
  }

  private boolean collisionDetected(Bird bird, Pipe[] pipes) {
    int birdX = bird.getX();
    int birdY = bird.getY();
    int birdWidth = 1; // Ширина пташки
    int birdHeight = 1; // Висота пташки

    for (int i = 0; i < pipes.length; i++) {
      Pipe pipe = pipes[i];
      int pipeX = pipe.getX();
      int pipeHeight = pipe.getHeight();
      int gapStart = pipe.getGapStart();
      int gapHeight = pipe.getGapHeight();
      int pipeWidth = 1; // Ширина труби

      // Перевірка зіткнення пташки з трубою
      if (birdX + birdWidth >= pipeX && birdX < pipeX + pipeWidth &&
          ((birdY >= 0 && birdY < pipeHeight) ||
              (birdY + birdHeight > gapStart && birdY + birdHeight <= gapStart + gapHeight))) {

        System.out.println("Отримано нове очко! Поточна кількість очок: " + score);
        System.out.println("Пташка зіткнулася з перешкодою номер " + (i + 1));
        return true;
      }
    }
    return false; // Якщо жодна зіткнення не виявлено, повертаємо false
  }

}