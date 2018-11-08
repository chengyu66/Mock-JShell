package a2;
import a2.FileSystem;
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
public class Cat extends Command{

  public Cat(FileSystem fs) {
    super(fs);
  }
  public void run(String[] input) {
    for (int i=1;i<input.length;i++) {
      if (this.isValid(input[i])) {
        FileDirectory fd = fs.trace(input[i]);
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
  
  public boolean isValid(String path) {
    boolean result = false;
    if (path.length()>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}
