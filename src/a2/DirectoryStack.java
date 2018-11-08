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
