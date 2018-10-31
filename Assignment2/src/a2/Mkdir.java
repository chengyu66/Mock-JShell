package a2;

public class Mkdir extends Command {
  
  public Mkdir(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    if (isValid(input)) {
      String output = "";
      Directory currDir = fs.getCurrentDirectory();
      int index;
      for (int i = 1; i < input.length; i++) {
        // check if input is a path
        if (input[i].contains("/")) {
          
        } else {
          //
          if (currDir.subExist(input[i])) {
            output = "Some Files or Directories already exist";
          } else {
            Directory newDirectory = new Directory(input[i],
                currDir);
            currDir.setSub(newDirectory); 
          }
          index = (currDir).findSub(input[i]);
          currDir = (Directory) currDir.getSub().get(index);
        }
      }
      if(output != "") {
        System.out.println(output);
      }
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }
  
  public boolean isValid(String[] input) {
    boolean result = false;
    if (input.length != 1) {
      result = true;
    }
    return result;
  }

  public String errorMessage() {
    return "correct format of Command mkdir: mkdir (DIRS or PATHS)";
  }
}
