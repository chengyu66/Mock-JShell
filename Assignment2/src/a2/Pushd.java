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
public class Pushd extends Command{
	
	public Pushd(FileSystem fs) {
		super(fs);
	}
	
	public void run(String[] input) {
		
		// input length is 2 means User may have a <path> parameter
		if (input.length == 2) {
			
			// Check the object at the path.
			String path = input[1];
			FileDirectory find= fs.trace(path);
			// if it's an instance of directory
			if (find instanceof Directory) {
				// get current directory 
				Directory currentDirectory = fs.getCurrentDirectory();
				// save the current directory into DirectoryStack
				fs.getDirectoryStack().push(currentDirectory);
				
				// change current Directory to the input path for directory
				fs.setCurrentDirectory((Directory) find);
				
			}
			// if it's an instance of File
			else if(find instanceof File){
				// suitable error message for user
				System.out.println(isFile());
			}
			else {
				System.out.println(pathNotExist());
				}
			}

		// input
		else {
			System.out.println(super.errorMessage());
		}
}
		
	
	public String isFile() {
	    return "correct format of Command pushd: pushd [dir], "
	    		+ "path of a file is invalid";
	}
	
	public String pathNotExist() {
	    return "Input path does not exist";
	}
	
}
