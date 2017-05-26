/**
 * 
 */
package mazeSolver;

/**
 * @author klaas
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maze maze=new Maze(10);
		int[] entrance=findEntrance(maze.getGrid());
		new TreeElement(entrance[0],entrance[1],true,null,maze);
		
	}
	
	/**
	 * 
	 * @param grid The maze grid
	 * @return The coordinates of the first entrance/exit found.
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

}
