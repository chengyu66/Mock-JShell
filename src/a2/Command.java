package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public abstract class Command {
  
  public static FileSystem fs;

  public Command(FileSystem fs) {
    Command.fs = fs;
  }

  // Every subClass should override this method
  public void run(String[] input) {}

  public boolean validName(String name) {
    Pattern p = Pattern.compile("[/.!@#$%^&*(){}~|<>?]");
    Matcher m = p.matcher(name);
    // boolean b = m.matches();
    boolean result = m.find();
    return !result;
  }
  
  public String errorMessage() {
    return "Wrong Input Format";
  }
}
