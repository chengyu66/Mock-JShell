package a2;
import a2.FileSystem;

public class PrintDirectory extends Command{

  public PrintDirectory(FileSystem fs) {
    super(fs);
  }

  public void run(String[] input) {
    if (fs!= null) {
      System.out.println(fs.getCurrentDirectory());
    }else {
      System.out.println(errorMessage());
    }
  }
  public String errorMessage() {
    return "FileSystem not created";
  }
}
