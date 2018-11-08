package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
