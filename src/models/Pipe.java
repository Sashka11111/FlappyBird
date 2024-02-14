package models;

import java.util.Random;

public class Pipe {
  private int x;
  private int height;
  private boolean isFinish; // Позначає, чи є труба фінішною
  private static final int SCREEN_HEIGHT = 20;
  private static final Random random = new Random();
  public static final int GAP_HEIGHT = 4; // Висота проміжку між трубами


  public Pipe(int x, boolean isFinish) {
    this.x = x;
    this.height = generateRandomHeight();
    this.isFinish = isFinish;
    this.x -= 1; // Враховуємо ширину труби
  }


  public int getX() {
    return x;
  }

  public int getHeight() {
    return height;
  }

  public int getGapStart() {
    return height + GAP_HEIGHT;
  }

  public int getGapHeight() {
    return GAP_HEIGHT;
  }

  private int generateRandomHeight() {
    return random.nextInt(SCREEN_HEIGHT - GAP_HEIGHT);
  }


  public void renderPipe(char[][] screen) {
    for (int i = 0; i < SCREEN_HEIGHT; i++) {
      if (i < height || i > height + GAP_HEIGHT) {
        screen[i][x] = '|';
      }
    }
  }
}
