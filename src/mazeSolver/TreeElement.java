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
	private static boolean solutionFound;
	
	public TreeElement(int xCoord,int yCoord,boolean root,TreeElement parent){
		if(!solutionFound){
			this.xCoord=xCoord;
			this.yCoord=yCoord;
			this.root=root;
			this.parent=parent;
			MazeReader.getGrid()[xCoord][yCoord]='V';//This means visited
			MazeReader.print();
			
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
