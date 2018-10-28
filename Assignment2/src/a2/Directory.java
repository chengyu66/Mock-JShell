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
	}
	
	public ArrayList<FileDirectory> getSub(){
		return subItem;
	}
}
