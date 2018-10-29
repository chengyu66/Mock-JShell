package a2;

public class FileSystem {
	
	private Directory root;
	private Directory currentDirectory;
	
	public FileSystem(String nameOfRoot) {
		this.root = new Directory(nameOfRoot, null);
		this.currentDirectory = root;
		
	}
	
	public void setCurrentDirectory(Directory newDirectory) {
		this.currentDirectory = newDirectory;
		
	}
	
	public Directory getCurrentDirectory() {
		return this.currentDirectory;
	}
	
	public Directory getRoot(){
		return this.root;
	}
	
	// this method is additional.
	// you pass in a path, FileSystem get to that directory
	// need to consider the case of File.
	public Directory trace(String path) {
		// Decompose the string <path> into the name of each folder
		String[] folders = path.split("/");

		// The directory currently getting examined
		Directory curr = this.getRoot();
				
		// loop through the folders
		for (String folderName: folders){
			int index = curr.findSub(folderName);
			// Directory doesn't exist
			if (index != -1) {
				curr = (Directory) curr.getSub().get(index);
			}
			else {
				return null;
			}
		}
		return curr;
	}
}
