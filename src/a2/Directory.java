package a2;

import java.util.ArrayList;
/**
 * The class represent the driectory.
 * It has the ability as the directory in the computer
 * It collects the file and directory.
 */
public class Directory extends FileDirectory{
	private ArrayList<FileDirectory> subItem;
	
	/**
	 * 
	   * the constructor of Directory
	   * initialize the subItem.
	   * @return None
	   */
	public Directory(String name, Directory parent){
		super(name, parent);
		this.subItem = new ArrayList<FileDirectory>();
	}
	
	/**
	   * set the File or Directory under this Directory.
	   * 
	   * @param items the variable represents the Directory to be sub
	   * @return None
	   */
	public void setSub(FileDirectory items){
		subItem.add(items);
		items.setParent(this);
	}
	
	/**
	   * return all file and directory under the directory
	   * 
	   * @param None 
	   * @return subItem The string list of all file
	   * and irectory under this directory.
	   */
	public ArrayList<FileDirectory> getSub(){
		return subItem;
	}
	
	/**
	   * Find the giving name in the array of file and directory.
	   * 
	   * @param name the file or directory's name
	   * @return the file or directory exist or not.
	   */
	public boolean subExist(String name) {
	  boolean result = false;
	  for(FileDirectory items: subItem) {
	    if (items.getName().equals(name)) {
	      result = true;
	    }
	  }
	  return result;
	}
	
	/**
	   * Find the index of giving name in the array of file and directory.
	   * 
	   * @param name the file or directory's name
	   * @return the index of file or directory exist or not.
	   */
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
