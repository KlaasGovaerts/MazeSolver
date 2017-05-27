package mazeSolver;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaas Govaerts
 * Test class for {@link mazeSolver.TreeElement}.
 */
public class TreeElementTest {
	private TreeElement element;
	private int[] entrance;
	ArrayList<TreeElement> children;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MazeReader.clear();
		TreeElement.restart();
		entrance=Application.findEntrance(MazeReader.getGrid());
		element=new TreeElement(entrance[0],entrance[1],true,null);
		children=element.getChildren();
	}

	/**
	 * Test method for {@link mazeSolver.TreeElement#getParent()}.
	 */
	@Test
	public void testGetParent(){
		assertEquals(element.getChildren().get(0).getParent(),element);
	}
	
	/**
	 * Test method for {@link mazeSolver.TreeElement#getChildren()}.
	 */
	@Test
	public void testGetChildren() {
		TreeElement child=children.get(0);
		assertEquals(children.size(),1);
		assertEquals(child.getX(),3);
		assertEquals(child.getY(),19);
	}

	/**
	 * Test method for {@link mazeSolver.TreeElement#getX()}.
	 */
	@Test
	public void testGetX() {
		assertEquals(element.getX(),3);
	}

	/**
	 * Test method for {@link mazeSolver.TreeElement#getY()}.
	 */
	@Test
	public void testGetY() {
		assertEquals(element.getY(),20);
	}

}
