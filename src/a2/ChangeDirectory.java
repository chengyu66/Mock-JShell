package a2;
/**
 * Construct Change Directory class, which is a command.
 * 
 * @param fs is a fileSystem
 * @return return None.
 */
import a2.FileSystem;

public class ChangeDirectory extends Command{

  public ChangeDirectory(FileSystem fs) {
    super(fs);
    
  }
  /**
   * Run method return None by given Split string input and 
   * change current directory by given path
   * 
   * @param input is a string input list split by "/"
   * @return return None.
   */
  public void run(String[] input) {
    // tell if the input list is valid length
    if (this.isValid(input)) {
      String path = input[1];
      FileDirectory fd = fs.trace(path);
      // tell if the FileDirectory found by path is a file
      if (fd instanceof File) {
        System.out.println("Not a directory");
      } else if (fd instanceof Directory) {
        //if the FileDirectory found by path is a Directory
        //set current directory to the FileDirectory found
        fs.setCurrentDirectory((Directory)fd);
      } else {
        System.out.println(errorMessage());
      }
    }else {
      System.out.println(super.errorMessage());
    }
  }
  
  public String errorMessage() {
    return "No such file or directory";
  }
  
  public boolean isValid(String[] input) {
    boolean result = false;
    // tell if the length if valid
    if (input.length>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}