package a2;
import a2.FileDirectory;
import a2.FileSystem;

public class PrintDirectory extends Command{
  public FileSystem all;
  
  
  public PrintDirectory(String input) {
    super(input);
    FileDirectory dir = all.getCurrentDirectory();
    String str = null;
    while (dir!=null) {
      str += dir.getName();
      dir = dir.getParent();
      if (dir!=null) {
        str += "/";
      }
    }
    System.out.println(str);
  }
}
