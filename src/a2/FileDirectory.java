package a2;
/**
 * The class is the parent class of File
 * and Directory. It has the methods for both 
 * two classes.
 */
public class FileDirectory {
	private String name;
	private FileDirectory parent;
	
	/**
	   * the constructor of FileDirectory
	   * initialize the name, parent.
	   * 
	   * @param name The name of FileSystem
	   * @param the FileDirectory
	   * @return return None
	   */
	public FileDirectory(String name, FileDirectory parent){
		this.name = name;
		this.parent = parent;
		
	}
	
	/**
	   * Get the name of the File or Directory.
	   * 
	   * @param None
	   * @return return the name of the File or Directory
	   */
	public String getName(){
		return this.name;
	}
	
	
	/**
	   * set parent of Directory or File.
	   * 
	   * @param the name of parent Directory
	   * @return None
	   */
	public void setParent(Directory parent){
		this.parent = parent;
	}
	
	/**
	   * get the parent of Directory or File.
	   * 
	   * @param None
	   * @return The parent FileDirectory 
	   */
	public FileDirectory getParent(){
		return this.parent;
	}
	
	/**
	   * output the path of this FileDirectory.
	   * 
	   * @param None
	   * @return the String path of this FileDirectory.
	   */
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
