import java.util.Random;

/**
 * RandomOccupant.java
 * RandomOccupant: An abstract class that extends Occupant to include properties
 * common to all not human-controlled maze occupants, namely: know how to generate
 * a random Square as its initial location and know how to move randomly around the Maze.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public abstract class RandomOccupant extends Occupant {
	// instance variables
	private Random rand;
	private Maze maze;

	// constructors 
	public RandomOccupant(Maze maze) {
		this.maze = maze;
		rand = new Random();
		int row = rand.nextInt(maze.rows());
		int col = rand.nextInt(maze.cols());
		Square random_loc = maze.getSquare(row, col);
		super.moveTo(random_loc);
	}

	public RandomOccupant(Maze maze, long seed) {
		this.maze = maze;
		rand = new Random(seed);
		int rows = rand.nextInt(maze.rows());
		int cols = rand.nextInt(maze.cols());
		Square new_loc = maze.getSquare(rows, cols);
		super.moveTo(new_loc);
	}

	public RandomOccupant(Maze maze, Square location) {
		super(location);
		this.maze = maze;
		rand = new Random();
	}

	// RandomOccupant Methods

	public void move() {
		int current_row = super.location().row();
		int current_col = super.location().col();
		int rand_dir = rand.nextInt(4);

		// while loop to loop through random integers until direction has no wall
		while (super.location().wall(rand_dir) == true) {
			rand_dir = rand.nextInt(4);
		}

		// if statements to move row and column accordingly
		if (rand_dir == Square.UP) {
			current_row -= 1;
		} else if (rand_dir == Square.RIGHT) {
			current_col += 1;
		} else if (rand_dir == Square.DOWN) {
			current_row += 1;
		} else if (rand_dir == Square.LEFT) {
			current_col -= 1;
		}

		// get location of new_loc and move there
		Square rand_loc = maze.getSquare(current_row, current_col);
		super.moveTo(rand_loc);
	}
}