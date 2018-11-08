package a2;

import java.util.Map;
import a2.FileSystem;

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
