import java.awt.event.KeyEvent;

/**
 * Explorer.java
 * Explorer: A class that extends Occupant to model an Explorer.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class Explorer extends Occupant {
	// instance variables
	private String name;
	private Maze maze;

	// constructor
	public Explorer(Square location, Maze maze, String name) {
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(super.location());
	}

	// Explorer Methods

	public String name() {
		return name;
	}

	public void move(int key) {
		// gets the row and column
		int row = super.location().row();
		int col = super.location().col();

		// if statements to see take the key inputted and move accordingly
		if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP) {
			row = row - 1;
			key = Square.UP;
		} else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT) {
			col = col + 1;
			key = Square.RIGHT;
		} else if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN) {
			row = row + 1;
			key = Square.DOWN;
		} else if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT) {
			col = col - 1;
			key = Square.LEFT;
		}

		// if there is no wall in direction of key inputted, 
		// get location of new_loc and move there
		if (super.location().wall(key) == false) {
			Square new_loc = maze.getSquare(row, col);
			this.moveTo(new_loc);
		}

	}

	public void moveTo(Square s) {
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
	}
}