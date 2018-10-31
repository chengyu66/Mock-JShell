package a2;

import java.util.ArrayList;


public class DirectoryStack {
	
	private ArrayList<Directory> content;
	public DirectoryStack() {
		this.content = new ArrayList<Directory>();

	}
	
	public void push(Directory dir) {
		this.content.add(dir);
		
		
	}
	
	public Directory pop() {
		int size = this.content.size();
		if (!(this.isEmpty())) {
			Directory result = this.content.get(size - 1);
			this.content.remove(size - 1);
			return result;
		}
		else {
			return null;
		}
		
	}
	
	
	public boolean isEmpty() {
		
		return this.content.size() == 0;
	}

}
