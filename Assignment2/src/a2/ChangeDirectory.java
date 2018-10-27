package a2;
import a2.Directory;

public class ChangeDirectory extends Command{
  public Directory dir;
  
  public void ChangeDirectory(String input) {
    super(input);
    String[] my_list = input.split(" ");
    String dir = my_list[1];
    String[] folder = dir.split("/");
    for (String f:folder) {
      // Depending on how team mates build Directory
      pass
    }
    
  }
  
}
