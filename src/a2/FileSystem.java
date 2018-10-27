package a2;

public class FileSystem {
	
	private Directory root;
	private Directory currentDirectory;
	
	public FileSystem(String nameOfRoot) {
		this.root = Directory(nameOfRoot, null);
		this.currentDirectory = root;
		
	}
	
	public void setCurrentDirectory(Directory newDirectory) {
		this.currentDirectory = newDirectory
		
	}
	
	public Directory getCurrentDirectory() {
		return this.currentDirectory
	}
	
	// this method is additional.
	// you pass in a path, FileSystem get to that directory
	public void Trace(String dir) {
}
