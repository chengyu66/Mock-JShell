package a2;
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
public class FileDirectory {
	private String name;
	private FileDirectory parent;
	

	public FileDirectory(String name, FileDirectory parent){
		this.name = name;
		this.parent = parent;
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setParent(Directory parent){
		this.parent = parent;
	}
	
	public FileDirectory getParent(){
		return this.parent;
	}
	
	public String toString(){
		String output = this.name;
		FileDirectory currParent = this.parent;
		
		while (currParent != null){
			output = currParent.getName()+"/"+output;
			currParent = currParent.getParent();
		}if (output.length()==0) {
		  output = "/"+output; 
		}
		return output;
	}
}
