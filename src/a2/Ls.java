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
public class Ls extends Command{
  
	/**
	 * the constructor of Ls
	 * 
	 * @param fs the FileSystem in JShell
	 * @return return none
	 */
  public Ls(FileSystem fs) {
    super(fs);
  }
  
  /**
   * Run the command and list all the directory
   * and file by the giving path
   * 
   * @param input a String array of user input without space
   * @return return None
   */
  public void run(String[] input) {
    String output = "";
    if (input.length == 1) {
      for (FileDirectory fd: fs.getCurrentDirectory().getSub()) {
        output += fd.getName() + "   ";
      }
      System.out.println(output.trim());
    } else if(input.length == 2) {
      String path = input[1]; 
      FileDirectory fd = fs.trace(path);
      if (fd instanceof File) {
        System.out.println(((File) fd).getContent());
      } else if (fd instanceof Directory) {
        String contents = "";
        for (FileDirectory fdContents: ((Directory) fd).getSub()) {
          contents += fdContents.getName() + "   ";
        }
        System.out.println(fd.getName() + ": " + contents.trim());
      } else {
        System.out.println("No such file or directory");
      }
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }

  public String errorMessage() {
    return "correct format of Command ls: ls [PATH]";
  }
}
