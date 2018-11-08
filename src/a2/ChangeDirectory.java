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
import a2.FileSystem;

public class ChangeDirectory extends Command{

  public ChangeDirectory(FileSystem fs) {
    super(fs);
    
  }
  public void run(String[] input) {
    if (this.isValid(input)) {
      String path = input[1];
      FileDirectory fd = fs.trace(path);
      if (fd instanceof File) {
        System.out.println("Not a directory");
      } else if (fd instanceof Directory) {
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
    if (input.length>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}