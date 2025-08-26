import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PFont;

public class Letter {
  private PApplet p;
  protected PVector location;
  protected int c;
  protected float w, h;
  protected float dy = 2f;
  protected PFont font1;
  protected PFont font2;
  protected PFont font3;

  public Letter(PApplet p, float x, float y, float w, float h, int c) {
    this.p = p;
    location = new PVector(x, y);
    this.c = c;
    this.w = w;
    this.h = h;
    font1 = p.loadFont("TimesNewRomanPS-BoldItalicMT-25.vlw");
    font2 = p.loadFont("TimesNewRomanPSMT-13.vlw");
  }

  public void display() {
    p.stroke(0);
    p.fill(255);
    p.rect(location.x, location.y, w*0.85f, h*0.85f);
    p.fill(c);
    p.rect(location.x, location.y, w*0.8f, h*0.775f);
    script();
  }

  public void script() {
    p.textFont(font1);
    p.textSize(25);
    p.fill(255);
    p.text("Happy Mother's Day Mami!", location.x - w*0.375f, location.y - h*0.27f);
    p.textFont(font2);
    p.textSize(15);
    p.text("Te agradezco por todo los sacrificios que has", location.x - w*0.35f, location.y - h*0.13f);
    p.text("hecho, no solo por mi, pero por tus hijas", location. x - w*0.35f, location.y - h*0.08f);
    p.text("tambien. Me da lastima que puedo estar", location. x - w*0.35f, location.y - h*0.03f);
    p.text("presente en este dia de celebracion pero", location. x - w*0.35f, location.y + h*0.02f);
    p.text("quiero que sepas que te amo tanto y estoy", location. x - w*0.35f, location.y + h*0.07f);
    p.text("tan agradecido y orgulloso de ser tu hijo. <3", location.x - w*0.35f, location.y + h*0.12f);
    p.text("- tu niño para siempre <3", location.x - w*0.35f, location.y + h*0.22f);
  }

  public void move() {
    if (location.y > p.height*0.5f) {
      location.y -= dy;
    } else {
      location.y = p.height*0.5f;
    }
  }
}
