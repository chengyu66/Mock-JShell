package a2;
import a2.Directory;

public class ChangeDirectory extends Command{
  public Directory dir;
  
  public ChangeDirectory(String input) {
    super(input);
    String[] folder = spart.split("/");
    for (String f:folder) {
      // Depending on how team mates build Directory
    }
    
  }
  
}
