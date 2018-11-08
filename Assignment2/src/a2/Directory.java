package a2;

import java.util.ArrayList;
/**
 * Determines how similar each pair of users is based on their ratings. This
 * similarity value is represented with with a float value between 0 and 1,
 * where 1 is perfect/identical similarity. Stores these values in the
 * userUserMatrix.
 * 
 * @param items1 is the column of the first user.
 * @param items2 is the column of the second user.
 * @return return a double represents the distance between users.
 */
public class Directory extends FileDirectory{
	private ArrayList<FileDirectory> subItem;
	
	public Directory(String name, Directory parent){
		super(name, parent);
		this.subItem = new ArrayList<FileDirectory>();
	}
	
	public void setSub(FileDirectory items){
		subItem.add(items);
		items.setParent(this);
	}
	
	public ArrayList<FileDirectory> getSub(){
		return subItem;
	}
	
	public boolean subExist(String name) {
	  boolean result = false;
	  for(FileDirectory items: subItem) {
	    if (items.getName().equals(name)) {
	      result = true;
	    }
	  }
	  return result;
	}
	
	public int findSub(String name){
		int num = 0, index = -1;
		
		while(num<subItem.size()){
			if (subItem.get(num).getName().equals(name)){
				index = num;
				break;
			}
			
			num++;
		}
		
		return index;
	}
}
