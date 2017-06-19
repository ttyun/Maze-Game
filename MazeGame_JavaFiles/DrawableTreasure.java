/**
 * DrawableTreasure.java
 * DrawableTreasure: A class that draws a Treasure.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableTreasure extends Treasure implements Drawable {
	// constructors 
	public DrawableTreasure(Maze maze) {
		super(maze);
	}

	public DrawableTreasure(Maze maze, long seed) {
		super(maze, seed);
	}

	public DrawableTreasure(Maze maze, Square location) {
		super(maze, location);
	}

	// Methods

	public void draw() {
		
	}
}