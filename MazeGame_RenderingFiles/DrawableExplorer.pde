/**
 * DrawableExplorer.pde
 * DrawableExplorer: A class that draws an Explorer.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableExplorer extends Explorer implements Drawable {
  // constructor 
  public DrawableExplorer(Square location, Maze maze, String name) {
    super(location, maze, name);
  }

  // Methods

  public void draw() {
    // draws cat
    pushMatrix();
    // moves with location of arrow kew
    translate(location().x() + 25, location().y() + 21);
    
    // left paw
    fill(#FF9900);
    ellipse(-7, 18, 5, 10);
    ellipse(-3, 18, 5, 10);
    ellipse(-5, 18, 5, 10);
    
    // right paw
    fill(#FF9900);
    ellipse(7, 18, 5, 10);
    ellipse(3, 18, 5, 10);
    ellipse(5, 18, 5, 10);
    
    // right ear
    fill(#FF9900);
    triangle(2, -7, 8, -15, 9, -7);
    
    // left ear
    fill(#FF9900);
    triangle(-2, -7, -8, -15, -9, -7);
    
    // left earlobes
    fill(#FF704D);
    triangle(-4, -7, -8, -10, -8, -7);
    
    // body
    fill(#FF9900);
    ellipse(0, 5, 30, 30);
    
    // head
    fill(#FF9900);
    ellipse(0, 0, 20, 20);
    
    // left eye
    fill(#FFFFFF);
    ellipse(-4, -2, 5, 5);
    fill(#000000);
    ellipse(-3, -2, 1, 1);
    
    // right eye
    fill(#FFFFFF);
    ellipse(4, -2, 5, 5);
    fill(#000000);
    ellipse(3, -2, 1, 1);
    
    // nose
    fill(#000000);
    triangle(-2, 2, 2, 2, 0, 4);
    
    // right whiskers
    fill(#000000);
    beginShape();
    curveVertex(4, 3);
    curveVertex(4, 3);
    curveVertex(5, 2);
    curveVertex(8, 1);
    curveVertex(12, 0);
    curveVertex(13, 0);
    curveVertex(15, 1);
    endShape();
    
    beginShape();
    curveVertex(4, 5);
    curveVertex(4, 5);
    curveVertex(5, 5);
    curveVertex(7, 4);
    curveVertex(12, 6);
    curveVertex(13, 6);
    curveVertex(15, 7);
    endShape();
    
    // left whiskers
    fill(#000000);
    beginShape();
    curveVertex(-4, 3);
    curveVertex(-4, 3);
    curveVertex(-5, 2);
    curveVertex(-8, 1);
    curveVertex(-12, 0);
    curveVertex(-13, 0);
    curveVertex(-15, 1);
    endShape();
    
    beginShape();
    curveVertex(-4, 5);
    curveVertex(-4, 5);
    curveVertex(-5, 5);
    curveVertex(-7, 4);
    curveVertex(-12, 6);
    curveVertex(-13, 6);
    curveVertex(-15, 7);
    endShape();
    
    // mouth
    fill(#000000);
    beginShape();
    curveVertex(-2, 6);
    curveVertex(-2, 6);
    curveVertex(0, 9);
    curveVertex(2, 6);
    curveVertex(2,6);
    endShape();
    
    popMatrix();
  }
}
