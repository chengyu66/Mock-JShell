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
	    ref = new FileSystem("");
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
	    FileDirectory curr;
	    if (path.startsWith("/")) {
	      curr = root;
        }else {
          curr = currentDirectory;
        }
		String[] folders = path.split("/");
		// The directory currently getting examined
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
            }else if (folderName.equals("..")) {
              if (curr != root) {
                curr = curr.getParent();
              }
            }else if (folderName.equals(".")) {
                // do nothing
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
