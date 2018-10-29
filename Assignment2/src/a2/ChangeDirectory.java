package a2;

import a2.FileSystem;

public class ChangeDirectory extends Command{

  public ChangeDirectory(FileSystem fs) {
    super(fs);
    
  }
  public void run(String[] input) {
    String path = input[1]; 
    Directory dir = fs.trace(path);
    fs.setCurrentDirectory(dir);
  }
}