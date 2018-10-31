package a2;

import a2.FileSystem;

public class ChangeDirectory extends Command{

  public ChangeDirectory(FileSystem fs) {
    super(fs);
    
  }
  public void run(String[] input) {
    if (this.isValid(input)) {
      String path = input[1];
      if (path.equals(".")) {// do nothing
      } else if (path.equals("..")) {
        Directory currentDirectory = fs.getCurrentDirectory();
        if (currentDirectory != fs.getRoot()) {
          fs.setCurrentDirectory((Directory) currentDirectory.getParent());
        }
      } else {
        FileDirectory fd = fs.trace(path);
        if (fd instanceof File) {
          System.out.println("Not a directory");
        } else if (fd instanceof Directory) {
          fs.setCurrentDirectory((Directory)fd);
        } else {
          System.out.println(errorMessage());
        }
      }
    }else {
      System.out.println(super.errorMessage());
    }
  }
  public String errorMessage() {
    return "No such file or directory";
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