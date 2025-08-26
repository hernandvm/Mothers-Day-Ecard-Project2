import processing.core.PVector;
import processing.core.PApplet;

public class Stars extends Objects {
  private int nSides = 10;
  private float rot;
  private float sz2;
  private int c2;

  public Stars(PApplet p, float x, float y, float s, int c) {
    super(p, x, y, s, c, p.random(-2, 2), p.random(-2, 2));
    rot = 0;
  }

  public Stars(PApplet p) {
    this(p, p.random(p.width), p.random(p.height), 30, p.color(p.random(255),
      p.random(255), p.random(255), p.random(255)));
  }

  public void display() {
    float x, y;
    float theta = rot;
    float sz2 = sz*0.6f;
    c2 = c + 50;


    p.noStroke();
    p.fill(c);
    p.beginShape();
    for (int i = 0; i < nSides; i++) {
      if (i % 2 != 0) {
        x = location.x + sz/2*p.cos(theta);
        y = location.y + sz/2*p.sin(theta);
      } else {
        x = location.x + sz*p.cos(theta);
        y = location.y + sz*p.sin(theta);
      }
      p.vertex(x, y);
      theta += p.TWO_PI/nSides;
    }
    p.endShape(p.CLOSE);
  }

  public void move() {
    rot = rot + 0.01F;
    location.add(speed);
    bounce();
  }
}
