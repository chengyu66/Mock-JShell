package a2;


public class Ls extends Command{
	
  /*
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
		
	}*/
  public Ls(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    String output = "";
    if (input.length == 1) {
      for (FileDirectory fd: fs.getCurrentDirectory().getSub()) {
        output += fd.getName() + "   ";
      }
      System.out.println(output.trim());
    } else if(input.length == 2) {
      // if input path
      // need trace
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }
  
  public String errorMessage() {
    return "correct format of Command ls: ls [PATH]";
  }
}
