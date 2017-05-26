/**
 * 
 */
package mazeSolver;

/**
 * @author Klaas Govaerts
 *
 */
public class TreeElement {
	private int xCoord;
	private int yCoord;
	private boolean root;
	private TreeElement[] children=new TreeElement[4];
	
	public TreeElement(int xCoord,int yCoord,boolean root){
	this.xCoord=xCoord;
	this.yCoord=yCoord;
	this.root=root;
	if(true){
		new TreeElement(xCoord,yCoord);
	}
}
