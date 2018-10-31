package a2;

public class FileSystem {
  
	private static FileSystem ref = null;
	private Directory root;
	private Directory currentDirectory;
	private DirectoryStack directoryStack;
	
	// this constructor creates a filesystem instance
	private FileSystem(String nameOfRoot) {
		this.root = new Directory(nameOfRoot, null);
		this.currentDirectory = root;
		this.directoryStack = new DirectoryStack();
		
	}
	
	public static FileSystem createInstanceOfFileSystem() {
	  if(ref == null) {
	    ref = new FileSystem("MyComputer");
	  }
	  return ref;
	}
	
	public void setCurrentDirectory(Directory newDirectory) {
		this.currentDirectory = newDirectory;
		
	}
	
	public Directory getCurrentDirectory() {
		return this.currentDirectory;
	}
	
	
	public DirectoryStack getDirectoryStack() {
		return directoryStack;
	}

	public void setDirectoryStack(DirectoryStack directoryStack) {
		this.directoryStack = directoryStack;
	}
	
	public Directory getRoot(){
		return this.root;
	}
	
	// this method is additional.
	// you pass in a path, FileSystem get to that directory
	// need to consider the case of File.
	public FileDirectory trace(String path) {
		// Decompose the string <path> into the name of each folder
	    if (path.startsWith("/")) {
	      path = path.substring(1);
	    }
		String[] folders = path.split("/");
		// The directory currently getting examined
		FileDirectory curr;
		if (folders[0].equals(root.getName())) {
		  curr=root;
		}else if (currentDirectory.findSub(folders[0])!=-1) {
		  curr=currentDirectory;
	    }else {
	      return null;
	    }
    // loop through the folders
		for (String folderName: folders){
		  if (curr instanceof Directory) {
		    int index = ((Directory) curr).findSub(folderName);
            // Directory found
            if (index != -1) {
                curr = ((Directory) curr).getSub().get(index);
            }
            else if (folderName.equals(root.getName())){
                curr = root;
            }else {
                return null;
            }
          // case when there is a file inside a path
		  } else {
		    System.out.println("File is not a directory");
		    return null;
		  }
		}
		return curr;
	}
}
