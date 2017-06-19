/**
 * Square.java
 * Square: A class to represent a Square in the Maze.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class Square {
	// named constants
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	// instance variables
	private boolean[] walls;
	private boolean seen;
	private boolean in_view;
	private int row, col;
	private Treasure treasure;

	// constructor
	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col) {
		// initialize and set default values
		walls = new boolean[4];
		walls[0] = up;
		walls[1] = right;
		walls[2] = down;
		walls[3] = left;
		this.row = row;
		this.col = col;
		seen = false;
		in_view = false;
		treasure = null;
	}

	// Square Methods 

	public boolean wall(int direction) {
		if (direction == UP) {
			return walls[0];
		} else if (direction == RIGHT) {
			return walls[1];
		} else if (direction == DOWN) {
			return walls[2];
		} else {
			return walls[3];
		}
	}

	// query methods for seen, inView, row, col, and treasure
	public boolean seen() {return seen;}
	public boolean inView() {return in_view;}
	public int row() {return row;}
	public int col() {return col;}
	public Treasure treasure() {return treasure;}

	public int x() {
		int x_query = SQUARE_SIZE * col;
		return x_query;
	}

	public int y() {
		int y_query = SQUARE_SIZE * row;
		return y_query;
	}

	public void setInView(boolean inView) {
		in_view = inView;
		if (inView == true) {
			seen = true;
		}
	}

	public void setTreasure(Treasure t) {
		treasure = t;
	}

	public void enter() {
		if (treasure != null) {
			treasure.setFound();
		}
	}
}