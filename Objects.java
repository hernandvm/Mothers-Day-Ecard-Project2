import processing.core.PVector;
import processing.core.PApplet;

public abstract class Objects {
  protected float sz;
  protected int c;
  protected PVector location;
  protected PApplet p;
  protected PVector speed;

  public Objects(PApplet p, float x, float y, float size, int c, float vx, float vy) {
    this.p = p;
    sz = size;
    this.c = c;
    location = new PVector(x, y);
    speed = new PVector(vx, vy);
  }

  public abstract void display();

  public abstract void move();

  protected void bounce() {
    if (location.x > p.width-sz/2) {
      location.x = p.width-sz/2;
      speed.x = - speed.x;
    }

    if (location.x < sz/2) {
      location.x = sz/2;
      speed.x = -speed.x;
    }

    if (location.y > p.height-sz/2) {
      location.y = p.height-sz/2;
      speed.y = -speed.y;
    }

    if (location.y < sz/2) {
      location.y = sz/2;
      speed.y = -speed.y;
    }
  }
}
