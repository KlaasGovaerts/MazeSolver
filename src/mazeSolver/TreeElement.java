/**
 * 
 */
package mazeSolver;

import java.util.ArrayList;

/**
 * @author Klaas Govaerts
 *
 */
public class TreeElement {
	private int xCoord;
	private int yCoord;
	private boolean root;
	private ArrayList<TreeElement> children=new ArrayList<TreeElement>();
	private TreeElement parent;
	private MazeReader maze;
	private static boolean solutionFound;
	
	public TreeElement(int xCoord,int yCoord,boolean root,TreeElement parent,MazeReader maze){
		if(!solutionFound){
			this.xCoord=xCoord;
			this.yCoord=yCoord;
			this.root=root;
			this.maze=maze;
			maze.getGrid()[xCoord][yCoord]='V';//This means visited
			
			
			//Will check all adjacent coordinates
			for(int i=-1;i<=1;i=i+2){
				for(int j=-1;j<=1;i=j+2){
					int xNew=xCoord+i;
					int yNew=yCoord+j;
					char result=maze.getGridAtCoord(xNew,yNew);
					if(result==' '){
						children.add(new TreeElement(xNew,yNew,false,this,maze));
					}
					if(result=='O'&&(!root)){
						solutionFound=true;
						maze.clear();
						TreeElement current=parent;
						while(current!=null){
							maze.getGrid()[current.getX()][current.getY()]='*';
							current=current.parent;
						}
					}
				}
			}
		}
	}
	
	public TreeElement getParent(){
		return parent;
	}
	
	public int getX(){
		return xCoord;
	}
	
	public int getY(){
		return yCoord;
	}
}
