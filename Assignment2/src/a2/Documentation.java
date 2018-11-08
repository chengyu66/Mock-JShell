package a2;

import java.util.HashMap;
import java.util.Map;


public class Documentation{
  private Map<String, String> map;
  public Documentation(){
    this.map = new HashMap<String, String>();
    map.put("pwd", "Print the current directory");
    map.put("mkdir", "Create a new directory");
    map.put("cd", "");
    map.put("ls", "");
    map.put("history", "");
    map.put("echo", "");
    map.put("cat", "");
    
    
  }
  public Map<String, String> getMap() {
    return map;
  }
  public void setMap(Map<String, String> map) {
    this.map = map;
  }
  

}
