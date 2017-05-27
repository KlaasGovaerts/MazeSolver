package mazeSolver;

/**
 * @author Klaas Govaerts
 * Solves a perfect Maze, with a single entry, exit and solution.
 * More info on the implementation see the bottom of this file.
 *
 */
public class Application {
	/**
	 * This method will read the maze.txt file, solve the maze, and print the output to the console.
	 * @param args Does nothing
	 */
	public static void main(String[] args) {
		System.out.println("Unsolved Maze:");
		MazeReader.print();
		
		int[] entrance=findEntrance(MazeReader.getGrid());
		new TreeElement(entrance[0],entrance[1],true,null);
		
		System.out.println("");
		System.out.println("Solved Maze:");
		MazeReader.print();
	}
	
	/**
	 * 
	 * @param grid The grid of the maze.
	 * @return An array with the coordinates of the first entrance/exit found.
	 */
	public static int[] findEntrance(char[][] grid){
		for(int i=0;i<grid.length;i++){
			if(grid[i][0]==' '){return new int[]{i,0};}
			if(grid[i][grid[0].length-1]==' '){return new int[]{i,grid[0].length-1};}
		}
		
		for(int j=0;j<grid[0].length;j++){
			if(grid[0][j]==' '){return new int[]{0,j};}
			if(grid[grid.length-1][j]==' '){return new int[]{grid.length-1,j};}
		}
		return null;
	}

	/*
	 * As asked in the assignment, here is some info about how the algorithm works:
	 * First, the maze is read from the file by the MazeReader class, with the generateGrid method (by using "Scanner").
	 * Then the entrance is searched, by looking at all the outer walls.
	 * A TreeElement is made, with coordinates of the entrance.
	 * This TreeElement generates it's children recursively for each adjacent corridor that was not visited yet.
	 * When a TreeElement is generated adjacent to the exterior of the maze, the maze has been solved.
	 * The path that leads to the exit, will then be plotted using '*'.
	 * A recursive TreeElement constructor was chosen because this seemed the simplest solution.
	 */
}
