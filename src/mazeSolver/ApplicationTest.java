/**
 * 
 */
package mazeSolver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author klaas
 *
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
}
