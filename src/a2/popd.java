package a2;


public class popd extends Command{
	
	public popd(FileSystem fs) {
		super(fs);
	}
	
	public void run(String[] input) {
		
		// There is at least one Directory in the DirectoryStack
		if (!(fs.getDirectoryStack().isEmpty())) {
			//
			Directory directory = fs.getCurrentDirectory();
			// change the directory to the top entry of DirectoryStack
			fs.setCurrentDirectory(directory);
			
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

