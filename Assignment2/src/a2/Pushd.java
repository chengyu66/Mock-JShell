package a2;

public class Pushd extends Command{
	
	public Pushd(FileSystem fs) {
		super(fs);
	}
	/**

	 * Save the current directory and go to the next directory.
	 * 
	 * @param array of [Command, String] 
	 * @return null
	 */
	
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
