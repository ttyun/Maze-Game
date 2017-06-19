/**
 * Monster.java
 * Monster: A class that extends RandomOccupant to model a Monster.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class Monster extends RandomOccupant {
	// no instance variables

	//constructors
	public Monster(Maze maze) {
		super(maze);
	}

	public Monster(Maze maze, long seed) {
		super(maze, seed);
	}

	public Monster(Maze maze, Square location) {
		super(maze, location);
	}
}