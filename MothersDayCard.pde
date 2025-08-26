/****************************************************************************
 * Project 2
 * Name: Victor Hernandez
 * E-mail: hernandv@lafayette.edu
 * Course: CS 105 - Section 01
 * Submitted: 05/05/2022
 *
 * Description: Mother's Day e-card, with music in the
 * background, as a gift for my mother.
 *
 * Inspiration: In class, there was an example of an e-card made by
 * a student from a past section of CS 105: Digital Media, in which they
 * designed an envelope that opens up to a letter with a special message.
 *
 * Acknowledgement of References:
 * Processing.org/reference
 * https://keyvan.net/2009/09/processing-getting-started/ (code for flowers)
****************************************************************************/
Objects[] deco;
Envelope env;
float envWidth = 400;
float envHeight = 275;

void setup() {
  size(625, 500);
  smooth();
  deco = new Objects[25];
  for (int i = 0; i < deco.length; i++) {
    if (i%2 == 0) {
      deco[i] = new Stars(this);
    } else {
      deco[i] = new Flowers(this);
    }
  }
  env = new Envelope(this, width/2.0f, height + envHeight/2f, envWidth, envHeight, 255);
}
void draw() {
  background(loadImage("backpic.jpg"));
  for (int i = 0; i < deco.length; i++){
    deco[i].display();
    deco[i].move();
  }
  env.display();
  saveFrame("frames/####.png");
  if (frameCount > 1200) {
    noLoop();
  }
  save("EcardByVic.png");
}
