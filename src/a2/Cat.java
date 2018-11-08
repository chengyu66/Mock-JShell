package a2;
import a2.FileSystem;
/**
 * Construct cat class which is a command
 * @param fs is a FileSystem.
 */
public class Cat extends Command{

  public Cat(FileSystem fs) {
    super(fs);
  }
  /**
   * Print the file content by given the path to the file.
   * @param fs is a FileSystem.
   * @return return None.
   */
  public void run(String[] input) {
    //loop through the second column to the end
    for (int i=1;i<input.length;i++) {
      //tell if each path is valid
      if (this.isValid(input[i])) {
        FileDirectory fd = fs.trace(input[i]);
        //if the FileDirectory found is a file 
        if (fd instanceof File) {
          File f = (File)fd;
          System.out.println(f.getContent() +"\n\n\n");
        }else {
          System.out.println("cat: /"+input[i]+" "+errorMessage());
        }
      }else {
        System.out.println("cat: /"+input[i]+" "+errorMessage());
      }
    }
  }

  public String errorMessage() {
    return "No such file or directory";
  }
  /**
   * Return true or false to tell if the path string is valid.
   * 
   * @param path is the input string.
   * @return return true or false.
   */
  public boolean isValid(String path) {
    boolean result = false;
    String[] folder = path.split("/");
    // split path to tell if is valid length
    if (folder.length>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}
