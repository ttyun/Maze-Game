/**
 * DrawableMaze.pde
 * DrawableMaze: A class that draws the Maze.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableMaze extends Maze implements Drawable {
  // constructors 
  public DrawableMaze(DrawableSquare[][] maze, int rows, int cols) {
    super(maze, rows, cols);
  }

  // Methods

  public void draw() {
    // fill color of the maze
    fill(#33334C);
    
    // draw rectangle the size of entire maze
    rect(0, 0, cols()*Square.SQUARE_SIZE, rows()*Square.SQUARE_SIZE);
    
    // loop through each square in the maze to draw itself
    for (int y=0; y<rows(); y++) {
      for (int x=0; x<cols(); x++) {
        ((DrawableSquare)this.getSquare(y, x)).draw();
      }
    }
    
    // loop through randomOccupants and draw Monsters(owls) and Treasures(fish)
    for (int i=0; i<getNumRandOccupants(); i++) {
      if (this.getRandomOccupant(i) instanceof Monster) {
        ((DrawableMonster)this.getRandomOccupant(i)).draw();
      } else if (this.getRandomOccupant(i) instanceof Treasure) {
        ((DrawableTreasure)this.getRandomOccupant(i)).draw();
      }
    }
    // draw the explorer(cat)
    ((DrawableExplorer)this.getExplorer()).draw();
  }
}
