package a2;

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
		String output = "/"+this.name;
		FileDirectory currParent = this.parent;
		
		while (currParent != null){
			output = "/"+currParent.getName()+output;
			currParent = currParent.getParent();
		}
		return output;
	}
}
