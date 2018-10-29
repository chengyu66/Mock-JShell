package a2;


public class Ls extends Command{
	
	public Ls() {
		
		// get the current directory
		Directory currentPath = FileSystem.getCurrentDirectory();
		
		// print all the contents(file and directory) in current directory
		for (FileDirectory contents: currentPath.subItem) {
			System.out.println(contents.getName());
		}
	
	}
	public Ls(String path) {
		
		// I will do this later, get Trace done first
		Directory targetPath = FileSystem.trace(path);
		
	}
}
