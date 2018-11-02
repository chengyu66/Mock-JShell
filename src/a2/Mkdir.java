package a2;

public class Mkdir extends Command {
  
  public Mkdir(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    if (isValid(input)) {
      String output = "";
      Directory currDir = fs.getCurrentDirectory();
      for (int i = 1; i < input.length; i++) {
        // check if input is a path
        if (input[i].contains("/")) {
          String[] directories = input[i].split("/");
          Directory dir = fs.getRoot();
          // if the input path starts from the root of filesystem
          if (dir.getName().equals(directories[0])) {
            int index;
            for (int j = 1; j < directories.length; j++) {
              index = dir.findSub(directories[j]);
              if (j == directories.length - 1) {
                if (index != -1){
                  System.out.println("File or directory already exists");
                }else {
                  Directory newDirectory = new Directory(directories[j],
                      dir);
                  dir.setSub(newDirectory); 
                }
              } else {
                // if there is such directory exists
                if (index != -1) {
                  try {
                    dir = (Directory) dir.getSub().get(index);
                  } catch (java.lang.ClassCastException e) {
                    System.out.println("File is not a directory");
                    break;
                  }
                } else {
                  System.out.println("No such file or directory");
                  break;
                } 
              }
            }
          } else {
            System.out.println("Wrong root directory,"
                + " try adding \\\"/\\\" in front of the path");
          }
        } else {
          //
          if (currDir.subExist(input[i])) {
            output = "Some Files or Directories already exist";
          } else {
            Directory newDirectory = new Directory(input[i],
                currDir);
            currDir.setSub(newDirectory);
          }
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
