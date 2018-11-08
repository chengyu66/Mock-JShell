package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {

  public static FileSystem fs;

  /**
   * Construct a command class with filesystem
   * 
   * @param fs is a filesystem already build
   * @return return None
   */
  public Command(FileSystem fs) {
    Command.fs = fs;
  }

  // Every subClass should override this method
  public void run(String[] input) {}

  /**
   * tell if the command name has symbol that non-valid
   * 
   * @param name is the String that contain Commmand names
   * @return return true/false
   */
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
