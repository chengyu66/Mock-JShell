package a2;

import java.util.Map;
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
public class Man extends Command{
  private Documentation doc;
  private Map<String, String> map;
  public Man(FileSystem fs) {
    super(fs);
    Documentation d = new Documentation();
    doc = d;
    map = doc.getMap();
  }
  public void run(String[] input) {
    if (this.isValid(input)) {
      if (map.get(input[1]) == null) {
      System.out.println(errorMessage());
      }else {
      System.out.println(map.get(input[1]));
      }
    }
    
  }
  public String errorMessage() {
    return "command not valid";
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
