import processing.core.PApplet;
import processing.core.PVector;

public class Envelope {
  private float w, h, topY, bottomY, leftX, rightX;
  private int c;
  private PApplet p;
  private PVector location;
  private float dy = 2f;
  private float dy1 = -2f;
  private float dx = 2f;
  private int letterC;
  private Letter letter;

  public Envelope(PApplet p, float x, float y, float w, float h, int c) {
    this.p = p;
    this.w = w;
    this.h = h;
    this.c = c;
    location = new PVector(x, y);
    topY = location.y + h*0.1f;
    bottomY = location.y;
    leftX = location.x;
    rightX = location.x;
    letterC = p.color(255, 0, 0);
    letter = new Letter(p, x, y, w, h, letterC);
  }

  public void display() {
    p.pushMatrix();
    p.stroke(0);
    p.fill(c);
    p.rectMode(p.CENTER);
    p.rect(location.x, location.y, w, h);
    p.fill(255,0,0, 100);
    p.rect(location.x, location.y, w, h);
    letter.display();
    p.fill(c);
    p.triangle(location.x - w/2, location.y - h/2, leftX, location.y + h*0.1f, location.x - w/2, location.y + h/2);
    p.triangle(location.x + w/2, location.y - h/2, rightX, location.y + h*0.1f, location.x + w/2, location.y + h/2);
    p.triangle(location.x - w/2, location.y + h/2, location.x + w/2, location.y + h/2, location.x, bottomY);
    p.triangle(location.x - w/2, location.y - h/2, location.x + w/2, location.y - h/2, location.x, topY);
    p.popMatrix();
    move();
  }

  public void move() {
    letter.move();
    location.y -= dy;
    topY -= dy;
    bottomY -= dy;
    open();
  }

  public void open() {
    if (location.y < p.height*0.5f) {
      location.y = p.height*0.5f;
      topY = location.y - h*0.5f;
      leftX = location.x - w*0.5f;
      rightX = location.x + w*0.5f;
      bottomY = location.y + h*0.5f;
    }
  }
}
