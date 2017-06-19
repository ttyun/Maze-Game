/**
 * DrawableTreasure.pde
 * DrawableTreasure: A class that draws a Treasure.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableTreasure extends Treasure implements Drawable {
  PImage treasure_image;
  PImage found_treasure;
  
  // constructors 
  public DrawableTreasure(Maze maze) {
    super(maze);
    treasure_image = loadImage("Treasure_Fish.png");
    found_treasure = loadImage("Found_Treasure.png");
  }

  public DrawableTreasure(Maze maze, long seed) {
    super(maze, seed);
    treasure_image = loadImage("Treasure_Fish.png");
    found_treasure = loadImage("Found_Treasure.png");
  }

  public DrawableTreasure(Maze maze, Square location) {
    super(maze, location);
    treasure_image = loadImage("Treasure_Fish.png");
    found_treasure = loadImage("Found_Treasure.png");
  }

  // Methods

  public void draw() {
    // check if inView and not found yet, draw treasure
    if (this.location().inView() == true && this.found() == false) {
      pushMatrix();
      
      translate(this.location().x() + 10, this.location().y() + 10);
      image(treasure_image, 0, 0);

      popMatrix();
    }
    
    // if found, found treasure image is drawn
    if (this.found() == true) {
      pushMatrix();
      
      translate(this.location().x() + 10, this.location().y() + 10);
      image(found_treasure, 0, 0);
      
      popMatrix();
    }
  }
}
