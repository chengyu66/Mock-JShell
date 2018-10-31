package a2;

import java.util.ArrayList;

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
