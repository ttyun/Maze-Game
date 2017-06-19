import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Tyler Yun 
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
        this.squares = squares;
        this.rows = rows;
        this.cols = cols;
		    randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // Methods

   public RandomOccupant getRandomOccupant(int index) {
       return randOccupants.get(index);
   }

   public int getNumRandOccupants() {
      return randOccupants.size();
    }

   // COMMANDS
   public void addRandomOccupant(RandomOccupant ro) {
       randOccupants.add(ro);
   }
	
   public void setExplorer(Explorer e) {
       explorer = e;
   }
	
   public void explorerMove(int key) {
      explorer.move(key);
   }
	
   public void randMove() {
       for (int i=0; i<randOccupants.size(); i++) {
           randOccupants.get(i).move();
       }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
      
      // if the randOccupant in arraylist is an instance of Monster, then check if its location is with explorer's
      for (int i=0; i<randOccupants.size(); i++) {
           if (randOccupants.get(i) instanceof Monster && randOccupants.get(i).location() == explorer.location()) {
               return MONSTER_WIN; 
           }
       } 

      if (this.foundAllTreasures() == true) {
          status = EXPLORER_WIN;
      }
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;

      // if randOccupant in array list is an instance of Treasure, check to see if a treasure has been found yet
      for (int i=0; i<randOccupants.size(); i++) { 
          if (randOccupants.get(i) instanceof Treasure) { 
              if (((Treasure)randOccupants.get(i)).found() == false) {
                return false;
              }
          }

      }
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
      
      // row and column variables
      int up_row = row - 1;
      int right_col = col + 1;
      int down_row = row + 1;
      int left_col = col - 1;


      // adjacent squares
      if (s.wall(Square.UP) == false) {

          this.getSquare(up_row, col).setInView(true);

      }

      if (s.wall(Square.RIGHT) == false) {

          this.getSquare(row, right_col).setInView(true);

      }

      if (s.wall(Square.DOWN) == false) {

          this.getSquare(down_row, col).setInView(true);

      }

      if (s.wall(Square.LEFT) == false) {

          this.getSquare(row, left_col).setInView(true);

      } 

      // diagonal squares

      // upper left diagonal
      if ((this.getSquare(row, col).wall(Square.LEFT) == false && this.getSquare(row, left_col).wall(Square.UP) == false) ||
         (this.getSquare(row, col).wall(Square.UP) == false && this.getSquare(up_row, col).wall(Square.LEFT) == false)) {

          this.getSquare(up_row, left_col).setInView(true);

      }

      // upper right diagonal
      if ((this.getSquare(row, col).wall(Square.RIGHT) == false && this.getSquare(row, right_col).wall(Square.UP) == false) ||
         (this.getSquare(row, col).wall(Square.UP) == false && this.getSquare(up_row, col).wall(Square.RIGHT) == false)) {

          this.getSquare(up_row, right_col).setInView(true);

      }

      // lower left diagonal
      if ((this.getSquare(row, col).wall(Square.DOWN) == false && this.getSquare(down_row, col).wall(Square.LEFT) == false) ||
         (this.getSquare(row, col).wall(Square.LEFT) == false && this.getSquare(row, left_col).wall(Square.DOWN) == false)) {

          this.getSquare(down_row, left_col).setInView(true);

      }

      // lower right diagonal
      if ((this.getSquare(row, col).wall(Square.DOWN) == false && this.getSquare(down_row, col).wall(Square.RIGHT) == false) ||
         (this.getSquare(row, col).wall(Square.RIGHT) == false && this.getSquare(row, right_col).wall(Square.UP) == false)) {

          this.getSquare(down_row, right_col).setInView(true);

      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
}