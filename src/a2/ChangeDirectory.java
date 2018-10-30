package a2;

import a2.FileSystem;

public class ChangeDirectory extends Command{

  public ChangeDirectory(FileSystem fs) {
    super(fs);
    
  }
  public void run(String[] input) {
    if (this.isCorrect(input)) {
      String path = input[1]; 
      Directory dir = fs.trace(path);
      if (dir != null){
      fs.setCurrentDirectory(dir);
      }
    }else {
      System.out.println(errorMessage());
    }
  }
  public String errorMessage() {
    return "No such file or directory";
  }
  public boolean isCorrect(String[] input) {
    boolean result = false;
    if (input.length>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}