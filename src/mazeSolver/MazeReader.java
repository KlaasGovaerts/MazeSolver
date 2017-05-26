/**
 * 
 */
package mazeSolver;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @author Klaas Govaerts
 * Reads the maze from a file
 *
 */
public class MazeReader {
	private static char[][] grid;
	
	/**
	 * Reads the maze file and stores it as a 2D char array
	 * 
	 *Source used:
	 *http://stackoverflow.com/questions/14209085/how-to-define-a-relative-path-in-java
	 */
	private static void generateGrid(){
		ArrayList<String> wordList=new ArrayList<String>();
			try {
				String filePath = new File("").getAbsolutePath();
				filePath+="\\maze.txt";
				File file = new File(filePath);
				Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					wordList.add(sc.nextLine());
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			grid=new char[wordList.size()][wordList.get(0).length()];
			for(int i=0;i<wordList.size();i++){
				grid[i]=wordList.get(0).toCharArray();
			}
	}
	
	private static void checkEmpty(){
		if(grid==null){
			generateGrid();
		}
	}
	
	/**
	 * @author Klaas Govaerts
	 * @param x The x coordinate you want to check.
	 * @param y The y coordinate you want to check.
	 * @return The state of the maze at that location
	 */
	public char getGridAtCoord(int x,int y){
		checkEmpty();
		try{
			return grid[x][y];
		} catch (ArrayIndexOutOfBoundsException exception) {
			return 'O'; //Returned when out of bounds
		}
	}
	
	/**
	 * @author Klaas Govaerts
	 * @return Grid The maze grid
	 */
	public char[][] getGrid(){
		checkEmpty();
		return grid;
	}
}
