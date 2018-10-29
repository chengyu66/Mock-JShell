package a2;
import a2.FileDirectory;
import a2.Directory;
import a2.FileSystem;
import java.util.ArrayList;

public class ChangeDirectory extends Command{
  public Directory dir;
  public FileSystem all;
  
  
  public ChangeDirectory(String input) {
    super(input);
    String[] folder = spart.split("/");
    dir = this.findDir(folder[-1]);
    all.setCurrentDirectory(dir);
    
  }
  public Directory findDir(String name) {
    Directory result = null;
    Directory cur = all.getRoot();
    ArrayList<Directory> sublist = null;
    if (cur!= null) {
      if (cur.getName()==name) {
        result = cur;
      }else {
        sublist = cur.getSub();
        while (sublist!=null) {
          for(Directory sub:cur.getSub()) {
            if (sub.getName()==name) {
              result = sub;
            }else {}
          }
          cur = sublist.remove(0);
          for (Directory sub:cur.getSub()) {
            if (sub != null) {
              sublist.add(0, sub);
            }
          }
        } 
      }
    }
    return result;
  }
}