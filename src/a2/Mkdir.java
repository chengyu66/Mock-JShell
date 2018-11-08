package a2;
/**
 * Determines how similar each pair of users is based on their ratings. This
 * similarity value is represented with with a float value between 0 and 1,
 * where 1 is perfect/identical similarity. Stores these values in the
 * userUserMatrix.
 * 
 * @param items1 is the column of the first user.
 * @param items2 is the column of the second user.
 * @return return a double represents the distance between users.
 */
public class Mkdir extends Command {
  
  public Mkdir(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    if (isValid(input)) {
      Directory currDir = fs.getCurrentDirectory();
      for (int i = 1; i < input.length; i++) {
        String output = "";
        // check if input is a path
        if (input[i].contains("/")) {
          int indexOfLastSlash = input[i].lastIndexOf("/");
          String partialPath = input[i].substring(0, indexOfLastSlash);
          String newDirectoryName = input[i].substring(indexOfLastSlash + 1);
          FileDirectory secondLastDir = fs.trace(partialPath);
          if (secondLastDir != null) {
            // check if the partial path is a directory
            if(secondLastDir instanceof Directory) {
              if(((Directory) secondLastDir).subExist(newDirectoryName)) {
                output = "Argument"+ i + ": File or directory with the same"
                    + " name already exists";
              } else if(!validName(newDirectoryName)) {
                output = "Argument"+ i + ": Invalid name with"
                    + " special character";
              } else {
                Directory newDirectory = new Directory(newDirectoryName,
                    (Directory)secondLastDir);
                ((Directory)secondLastDir).setSub(newDirectory);
              }
            // else it is a file
            } else {
              output = "Argument"+ i + ": Cannot make new directoy in a File";
            }
          }else {
            output = "Argument"+ i + ": No such directory to add new directory";
          }
        } else {
          //
          if (currDir.subExist(input[i])) {
            output = "Argument"+ i + ": Some Files or Directories"
                + " already exist";
          } else if(!validName(input[i])) {
            output = "Argument"+ i + ": Invalid name with special character";
          } else {
            Directory newDirectory = new Directory(input[i],
                currDir);
            currDir.setSub(newDirectory);
          }
        }
      if(output != "") {
        System.out.println(output);
      }
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
