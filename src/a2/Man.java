package a2;

import java.util.Map;
import a2.FileSystem;
/**
 * Man class is a command to be construct
 * 
 * @param doc is a class with all documentations stored
 * @param map is the hashmap stored in the documentation class
 * @param fs is FileSystem to fit command format
 * @return return None
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
  /**
   * run method return none but print the documentaiotn
   * by the given command string
   * 
   * @param input is a string input list split by "/"
   * @return return None
   */
  public void run(String[] input) {
    if (this.isValid(input)) {
      // tell if input command string not in the hashmap
      if (map.get(input[1]) == null) {
      System.out.println(errorMessage());
      }else {
      // get its documentation
      System.out.println(map.get(input[1]));
      }
    }
    
  }
  public String errorMessage() {
    return "command not valid";
  }
  
  public boolean isValid(String[] input) {
    boolean result = false;
    // tell if the length of the string input list split by "/"
    // is valid
    if (input.length>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}
