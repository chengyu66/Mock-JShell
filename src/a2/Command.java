package a2;


public abstract class Command {
  
  public static FileSystem fs;

  public Command(FileSystem fs) {
    Command.fs = fs;
  }

  // Every subClass should override this method
  public void run(String[] input) {}

  
  public String errorMessage() {
    return "Wrong Input Format";
  }
}
