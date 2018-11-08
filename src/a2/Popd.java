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
public class Popd extends Command{
	
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

