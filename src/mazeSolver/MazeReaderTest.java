package mazeSolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaas Govaerts
 * Test class for {@link mazeSolver.MazeReader}.
 */
public class MazeReaderTest {
	private char[][] grid;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		grid=MazeReader.getGrid();
	}

	/**
	 * Test method for {@link mazeSolver.MazeReader#getGridAtCoord(int, int)}.
	 * Note: this test method is made for the current maze.txt file.
	 */
	@Test
	public void testGetGridAtCoord() {
		//Note: the origin is top left, with the x axis vertical down, and the y axis horizontal.
		assertEquals(MazeReader.getGridAtCoord(3,20),' ');
		assertEquals(MazeReader.getGridAtCoord(30,20),'O');//Out of bounds
		assertEquals(MazeReader.getGridAtCoord(-1,-1),'O');//Out of bounds
		assertEquals(MazeReader.getGridAtCoord(4,3),' ');
		assertEquals(MazeReader.getGridAtCoord(4,4),'X');
	}

	/**
	 * Test method for {@link mazeSolver.MazeReader#getGrid()}.
	 * Note: this test method is made for the current maze.txt file.
	 */
	@Test
	public void testGetGrid() {
		String[] expected=new String[]{
				"XXXXXXXXXXXXXXXXXXXXX",
				"X   X X   X X X   X X",
				"X XXX X XXX X XXX X X",
				"X   X   X X   X   X  ",
				"XXX X XXX X XXXXX X X"
			};
		for(int i=0;i<expected.length;i++){
			for(int j=0;j<expected[i].length();j++){
				assertEquals(grid[i][j],expected[i].charAt(j));
			}
		}
	}

	/**
	 * Test method for {@link mazeSolver.MazeReader#clear()}.
	 */
	@Test
	public void testClear() {
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]==' '){
					grid[i][j]='V';
				}
			}
		}
		MazeReader.clear();
		for(char[] charArray:grid){
			for(char c:charArray){
				assertTrue(c!='V');
			}
		}
	}
}
