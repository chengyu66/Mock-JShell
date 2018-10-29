package a2;

public class Mkdir extends Command {
  
  public Mkdir(FileSystem fs) {
    super(fs);
  }
  
  public void run(String[] input) {
    if (isValid(input)) {
      if (input[1].contains("/")) {
        //
      } else {
        Directory newDirectory = new Directory(input[1],
            fs.getCurrentDirectory());
        (fs.getCurrentDirectory()).setSub(newDirectory);
      }
    } else {
      System.out.println(super.errorMessage());
      System.out.println(errorMessage());
    }
  }
  
  public boolean isValid(String[] input) {
    boolean result = false;
    if (input.length == 2) {
      result = true;
    }
    return result;
  }

  public String errorMessage() {
    return "correct format of Command mkdir: mkdir [DIR or PATH]";
  }
}
