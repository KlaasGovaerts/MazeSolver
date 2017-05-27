package mazeSolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaas Govaerts
 * Test class for {@link mazeSolver.Application}.
 */
public class ApplicationTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link mazeSolver.Application#findEntrance(char[][])}.
	 */
	@Test
	public void testFindEntrance() {
		char[][] mazeNoEntrance=new char[5][10];
		assertEquals(Application.findEntrance(mazeNoEntrance),null);
		
		int[][] toCheck=new int[][]{
			{0,3},
			{4,3},
			{3,0},
			{3,9},
		};
		for(int i=0;i<4;i++){
			char[][] mazeWithEntrance=new char[5][10];
			mazeWithEntrance[toCheck[i][0]][toCheck[i][1]]=' ';
			assertEquals(Application.findEntrance(mazeWithEntrance)[0],toCheck[i][0]);
			assertEquals(Application.findEntrance(mazeWithEntrance)[1],toCheck[i][1]);
		}
	}

	/**
	 * Test method for {@link mazeSolver.Application#main}.
	 * Source used: https://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
	 */
	@Test
	public void testMain(){
		char[][] grid=MazeReader.getGrid();
		char[][] gridbefore=new char[grid.length][];
		for(int i = 0; i < grid.length; i++)
			gridbefore[i] = grid[i].clone();
		Application.main(null);
		char[][] gridafter=MazeReader.getGrid();
		for(int i=0;i<gridbefore.length;i++){
			for(int j=0;j<0;j++){
				if(gridbefore[i][j]=='X'){
					assertTrue(gridafter[i][j]=='X');
				}
				if(gridbefore[i][j]==' '){
					assertTrue(gridafter[i][j]==' '||gridafter[i][j]=='*');
				}
			}
		}
	}
}
