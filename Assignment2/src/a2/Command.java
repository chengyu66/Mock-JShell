package a2;

public class Command {
  
  private static String[] validCommands =
    {"exit", "mkdir", "cd", "is", "pwd", "pushd", "popd", "history", "cat",
        "echo", "man"};
  
  public Command() {
    
  }
  
  public String[] getValidCommands() {
    return validCommands;
  }
  
  // every subclass of Command should override this method
  public void run() {}
  
  public boolean isValid() {
    return true;
  }
}
