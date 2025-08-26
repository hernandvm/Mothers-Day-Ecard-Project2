import processing.core.PVector;
import processing.core.PApplet;

public class Flowers extends Objects {

  public Flowers(PApplet p, float x, float y, float s, int c) {
    super(p, x, y, s, c, p.random(-2, 2), p.random(-2, 2));
  }

  public Flowers(PApplet p) {
    this(p, p.random(p.width), p.random(p.height), 30, p.color(p.random(255),
      p.random(255), p.random(255), p.random(255)));
  }

  public void display() { // source code for flower drawing is acknowledged in references
    p.fill(c);
    p.pushMatrix();
    p.translate(location.x, location.y);
    for (int i = 0; i < 5; i++) {
      p.ellipse(0, -10, sz, sz);
      p.rotate(p.radians(72));
    }
    p.fill(c);
    p.ellipse(0, 0, sz, sz);
    p.popMatrix();
  }

  public void move() {
    location.add(speed);
    bounce();
  }
}
