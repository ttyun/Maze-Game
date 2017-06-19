/**
 * DrawableSquare.pde
 * DrawableSquare: A class that draws a Square.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableSquare extends Square implements Drawable {
  
  PImage bgrn_img;
  PImage bgrn_img_tinted;
  PImage branch;
  PImage branch_rotated;
  
  // constructor that uses Square constructor
  public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col) {
    super(up, right, down, left, row, col);
    bgrn_img = loadImage("Background_Grass.png");
    bgrn_img_tinted = loadImage("Background_Grass_tinted.png");
    branch = loadImage("branch.png");
    branch_rotated = loadImage("branch_left_right.png");
  }

  // DrawableSquare method

  public void draw() {
    // if it is seen and inView, draw grass in normal shade
    if (this.seen() == true && this.inView() == true) {
      image(bgrn_img, this.x(), this.y());
      
      // draw walls (branches)
      if (this.wall(UP) == true) {
        image(branch, this.x(), this.y());
      }
      
      if (this.wall(DOWN) == true) {
        image(branch, this.x(), this.y() + SQUARE_SIZE - 4);
      }
      
      if (this.wall(LEFT) == true) {
        image(branch_rotated, this.x(), this.y());
      }
      
      if (this.wall(RIGHT) == true) {
        image(branch_rotated, this.x() + SQUARE_SIZE - 4, this.y());
      }
        
    // else if it's seen but not inView anymore, draw grass in darker shade
    } else if (this.seen() == true && this.inView() == false) {
      image(bgrn_img_tinted, this.x(), this.y());
      
      // draw walls (branches)
      if (this.wall(UP) == true) {
        image(branch, this.x(), this.y());
      }
      
      if (this.wall(DOWN) == true) {
        image(branch, this.x(), this.y() + SQUARE_SIZE - 4);
      }
      
      if (this.wall(LEFT) == true) {
        image(branch_rotated, this.x(), this.y());
      }
      
      if (this.wall(RIGHT) == true) {
        image(branch_rotated, this.x() + SQUARE_SIZE - 5, this.y());
      }
    }
  }
}
