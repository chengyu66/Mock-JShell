package a2;


public class Popd extends Command{
	/**
	 * This class gets the user to the most recent directory from 
	 * the DirectoryStack. And changes the directory to that the top entry. 
	 * 
	 * @param fs which is a FileSystem
	 * @return null
	 */
	public Popd(FileSystem fs) {
		super(fs);
	}
	
	public void run(String[] input) {
		
		// There is at least one Directory in the DirectoryStack
		if (!(fs.getDirectoryStack().isEmpty())) {
			// The directory on the top of the entry
			Directory topDirectory = fs.getDirectoryStack().pop();
			// change the directory to the top entry of DirectoryStack
			fs.setCurrentDirectory(topDirectory);
			
		}
		// No Directory in the stack
		else {
			// send a message to the user
			System.out.println(EmptyDirectoryStackError());
			
		}
	}
	public String EmptyDirectoryStackError() {
	    return "DirecotryStack is empty";
	  }

}

