/**
 * Treasure.java
 * Treasure: A class that extends RandomOccupant to model a Treasure.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class Treasure extends RandomOccupant {
	// instance variables
	private boolean found;

	// constructors
	public Treasure(Maze maze) {
		super(maze);
		found = false;
		this.location().setTreasure(this);
	}

	public Treasure(Maze maze, long seed) {
	    super(maze, seed);
		found = false;
		this.location().setTreasure(this);
	}

	public Treasure(Maze maze, Square location) {
		super(maze, location);
		found = false;
		this.location().setTreasure(this);
	}

	// Treasure Methods

	public boolean found() {
		return found;
	}

	public void setFound() {
		found = true;
	}

	public void move() {
	}
}