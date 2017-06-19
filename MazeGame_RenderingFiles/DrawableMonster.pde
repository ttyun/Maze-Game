/**
 * DrawableMonster.pde
 * DrawableMonster: A class that draws the Monster.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableMonster extends Monster implements Drawable {
  // constructors 
  public DrawableMonster(Maze maze) {
    super(maze);
  }

  public DrawableMonster(Maze maze, long seed) {
    super(maze, seed);
  }

  public DrawableMonster(Maze maze, Square location) {
    super(maze, location);
  }

  // Methods

  public void draw() {
    // if location is inView, draw the Monster (owl)
    if (location().inView() == true) {
      // draws owl
      pushMatrix();
      translate(location().x() + 25, location().y() + 25);
    
      // feet left
      fill(#FFB84D);
      stroke(#000000);
      ellipse(-8, 17, 4, 10);
      ellipse(-4, 17, 4, 10);
      ellipse(-6, 17, 4, 10);
      
      // feet right
      fill(#FFB84D);
      stroke(#000000);
      ellipse(8, 17, 4, 10);
      ellipse(4, 17, 4, 10);
      ellipse(6, 17, 4, 10);
    
      // head
      fill(#663300);
      ellipse(0, 0, 36, 35);
    
      // arms
      beginShape();
      curveVertex(13, -10);
      curveVertex(14, -4);
      curveVertex(15, -3);
      curveVertex(20, 0);
      curveVertex(22, 10);
      curveVertex(20, 15);
      curveVertex(17, 7);
      curveVertex(13, -10);
      endShape();
    
      // arms
      beginShape();
      curveVertex(-13, -10);
      curveVertex(-13, -4);
      curveVertex(-15, -3);
      curveVertex(-20, 0);
      curveVertex(-22, 10);
      curveVertex(-20, 15);
      curveVertex(-17, 7);
      curveVertex(-13, -10);
      endShape();
    
      // eyes
      fill(#FFFFFF);
      ellipse(-5, -6, 12, 13);
      ellipse(5, -6, 12, 13);
    
      fill(#000000);
      ellipse(-4, -6, 6, 6);
      ellipse(4, -6, 6, 6);
    
      fill(#FFFFFF);
      ellipse(-4, -6, 1, 1);
      ellipse(4, -6, 1, 1);
    
      // body color
      fill(#FFFFFF);
      ellipse(0, 9, 12, 15);
    
      //nose
      fill(#FFB84D);
      triangle(-4, 0, 4, 0, 0, 6);
    
      popMatrix(); 
    }
  }
}
