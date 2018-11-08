package a2;
/**
 * The class has the ability to use the File and Directory
 * Class to trace the path and set and get the current Directory
 * for the relative path.
 */
public class FileSystem {
  
	private static FileSystem ref = null;
	private Directory root;
	private Directory currentDirectory;
	private DirectoryStack directoryStack;
	
	/**
	   * The constructor of FileSystem
	   * initialize the root currentDirectory and directoryStack
	   * 
	   * @param input a String array of user input without space
	   * @return return None
	   */
	// this constructor creates a filesystem instance
	private FileSystem(String nameOfRoot) {
		this.root = new Directory(nameOfRoot, null);
		this.currentDirectory = root;
		this.directoryStack = new DirectoryStack();
		
	}
	
	/**
	   * Create a instance FileSystem
	   * 
	   * @param None
	   * @return return a instance FileSystem
	   */
	public static FileSystem createInstanceOfFileSystem() {
	  if(ref == null) {
	    ref = new FileSystem("");
	  }
	  return ref;
	}
	
	/**
	   * It has the ability to set the current Directory
	   * the current Directory is relate to the relative path.
	   * 
	   * @param input a String array of user input without space
	   * @return return None
	   */
	public void setCurrentDirectory(Directory newDirectory) {
		this.currentDirectory = newDirectory;
		
	}
	
	/**
	   * output the current Directory
	   * 	   * 
	   * @param None
	   * @return return current Directory.
	   */
	public Directory getCurrentDirectory() {
		return this.currentDirectory;
	}
	
	/**
	   * get the directory Stack
	   *
	   * @param None
	   * @return return directory stack
	   */
	public DirectoryStack getDirectoryStack() {
		return directoryStack;
	}

	/**
	   * Set the Directory Stack
	   * 	   * 
	   * @param Direactory Stack
	   * @return return None.
	   */
	public void setDirectoryStack(DirectoryStack directoryStack) {
		this.directoryStack = directoryStack;
	}
	
	public Directory getRoot(){
		return this.root;
	}
	
	/**
	   * you pass in a path, FileSystem get to that directory
	   * need to consider the case of File.
	   * 
	   * @param path the string variable represent.
	   * @return return the directory or the file in that path
	   */
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
