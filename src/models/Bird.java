package models;

public class Bird {
  private int x;
  private int y;
  private int horizontalSpeed; // Швидкість руху по горизонталі

  public Bird(int x, int y) {
    this.x = x;
    this.y = y;
    this.horizontalSpeed = 0; // Початкова горизонтальна швидкість
  }

  public void moveUp() {
    if (y > 0) {
      y -= 3; // Зміщення вгору
      x += horizontalSpeed; // Рух по горизонталі
    }
  }

  public void moveDown() {
    if (y > 0) {
      y += 3; // Зміщення вниз
    x += horizontalSpeed; // Рух по горизонталі
    }
  }
  public void move(){
    x += horizontalSpeed; // Рух по горизонталі
  }

  public void setHorizontalSpeed(int speed) {
    this.horizontalSpeed = speed; // Встановлення горизонтальної швидкості
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
