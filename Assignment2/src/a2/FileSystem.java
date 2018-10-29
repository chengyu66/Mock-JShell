package a2;

public class FileSystem {
	
	private Directory root;
	private Directory currentDirectory;
	
	public FileSystem(String nameOfRoot) {
		this.root = Directory(nameOfRoot, null);
		this.currentDirectory = root;
		
	}
	
	public void setCurrentDirectory(Directory newDirectory) {
		this.currentDirectory = newDirectory;
		
	}
	
	public Directory getCurrentDirectory() {
		return this.currentDirectory;
	}
	
	// this method is additional.
	// you pass in a path, FileSystem get to that directory
	public void Trace(String path) {
		// Decompose the string <path> into the name of each folder
		String[] folders = path.split("/");
		
		// The directory currently getting examined
		Directory curr = FileSystem.getRoot();
				
		// loop through the folders
		For (String folderName: folders);{
			int index = curr.findSub(folderName);
			// Directory doesn't exist
			if (index != -1) {
				ArrayList<FileDirectory> currList = curr.findSub(folderName);
				
				curr = currList.getIndex(index);
			}
		}
		return curr;
	}
}
