package controllers;

import models.Bird;
import models.Pipe;

public class GameRenderer {
  private static final int SCREEN_WIDTH = 50;
  private static final int SCREEN_HEIGHT = 20;

  public static void render(Bird bird, Pipe[] pipes) {
    char[][] screen = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

    // Очищаємо екран
    clearScreen(screen);

    // Малюємо пташку
    drawBird(screen, bird);

    // Малюємо труби
    drawPipes(screen, pipes);

    // Виводимо екран на консоль
    printScreen(screen);
  }

  private static void clearScreen(char[][] screen) {
    for (int i = 0; i < SCREEN_HEIGHT; i++) {
      for (int j = 0; j < SCREEN_WIDTH; j++) {
        screen[i][j] = ' ';
      }
    }
  }

  private static void drawBird(char[][] screen, Bird bird) {
    // Малюємо пташку
    int birdX = bird.getX();
    int birdY = bird.getY();
    if (birdY >= 0 && birdY < SCREEN_HEIGHT && birdX >= 0 && birdX < SCREEN_WIDTH) {
      screen[birdY][birdX] = '^'; // Відображаємо пташку як '^'
    }
  }

  private static void drawPipes(char[][] screen, Pipe[] pipes) {
    // Малюємо труби
    for (Pipe pipe : pipes) {
      pipe.renderPipe(screen);
    }
  }

  private static void printScreen(char[][] screen) {
    for (int i = 0; i < SCREEN_HEIGHT; i++) {
      for (int j = 0; j < SCREEN_WIDTH; j++) {
        System.out.print(screen[i][j]);
      }
      System.out.println();
    }
  }
}
