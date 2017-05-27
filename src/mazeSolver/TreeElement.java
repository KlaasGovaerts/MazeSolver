package mazeSolver;

import java.util.ArrayList;

/**
 * @author Klaas Govaerts
 * Each TreeElements represents a possible path in the maze.
 */
public class TreeElement {
	private int xCoord;
	private int yCoord;
	private boolean root;
	private ArrayList<TreeElement> children=new ArrayList<TreeElement>();
	private TreeElement parent;
	private static boolean solutionFound;
	
	/**
	 * 
	 * @param xCoord The x coordinate
	 * @param yCoord The y coordinate
	 * @param root "true" if root of the tree.
	 * @param parent The parent of the TreeElement. Should be null if root.
	 * This is the constructor of the TreeElement (each TreeElement represents a path in the maze.)
	 * Will generate it's children recursively.
	 */
	public TreeElement(int xCoord,int yCoord,boolean root,TreeElement parent){
		if(!solutionFound){
			this.xCoord=xCoord;
			this.yCoord=yCoord;
			this.root=root;
			this.parent=parent;
			MazeReader.getGrid()[xCoord][yCoord]='V';//This means visited
			
			//Will check all adjacent coordinates
			for(int i=0;i<4;i++){
					int xNew=xCoord;
					int yNew=yCoord;
					switch(i){
					case 0:
						yNew=yCoord+1;
						break;
					case 1:
						xNew=xCoord+1;
						break;
					case 2:
						xNew=xCoord-1;
						break;
					case 3:
						yNew=yCoord-1;
						break;
					}
					char result=MazeReader.getGridAtCoord(xNew,yNew);
					if(result==' '){
						children.add(new TreeElement(xNew,yNew,false,this));
					}
					if(result=='O'&&(!root)){
						solutionFound=true;
						MazeReader.clear();
						TreeElement current=this;
						while(current!=null){
							MazeReader.getGrid()[current.getX()][current.getY()]='*';
							current=current.getParent();
							}
						}
					}
				}
			}
	
	/**
	 * 
	 * @return The parent of the TreeElement
	 */
	public TreeElement getParent(){
		return parent;
	}
	
	/**
	 * 
	 * @return The children of the treeElement
	 */
	public ArrayList<TreeElement> getChildren(){
		return children;
	}
	/**
	 * 
	 * @return The x coordinate
	 */
	public int getX(){
		return xCoord;
	}
	
	/**
	 * 
	 * @return The y coordinate
	 */
	public int getY(){
		return yCoord;
	}
	
	/**
	 * Run this method when generating the tree a second time.
	 */
	public static void restart(){
		solutionFound=false;
	}
}
